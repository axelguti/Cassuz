package cassuz.examples.com.dao;

import cassuz.examples.com.DTO.ListaPreciosDTO;
import cassuz.examples.com.conexion.Conexion;
import cassuz.examples.com.interfaces.ListaPrecioInterface;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaPreciosDAO implements ListaPrecioInterface {
    private Connection cn;
    private CallableStatement stm = null;

    @Override
    public String grabar(ListaPreciosDTO productos) {
        String result = "";
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("exec SP_C_PRODUCTO ?,?,?,?,?,?");
            stm.setInt(1, productos.getPagina());
            stm.setString(2, productos.getMarca());
            stm.setString(3, productos.getCodigo());
            stm.setString(4, productos.getColor());
            stm.setString(5, String.valueOf(productos.getPreciopublico()));
            stm.setString(6, String.valueOf(productos.getPreciopromotor()));
            int f = stm.executeUpdate();
            result = "se afecto " + f + " filas";
            stm.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public String modificar(ListaPreciosDTO productos) {
        return null;
    }

    @Override
    public String eliminar(Object id) {
        return null;
    }

    @Override
    public List<ListaPreciosDTO> listar() {
        List<ListaPreciosDTO> listar = new ArrayList<>();
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("SP_R_PRODUCTO");
            ResultSet rs = stm.executeQuery();
            ListaPreciosDTO obj;
            while (rs.next()) {
                obj = new ListaPreciosDTO();
                obj.setPagina(rs.getInt("pagproducto"));
                obj.setMarca(rs.getString("marcaproducto"));
                obj.setCodigo(rs.getString("codproducto"));
                obj.setColor(rs.getString("colorproducto"));
                obj.setPreciopublico(rs.getDouble("preciopublicoproducto"));
                obj.setPreciopromotor(rs.getDouble("preciopromotorproducto"));
                listar.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listar;
    }


    @Override
    public String Importar(File file) {
        String result = "";
        try {
            FileInputStream fi = new FileInputStream(file);
            XSSFWorkbook archivoExcel = new XSSFWorkbook(fi);
            XSSFSheet hoja = archivoExcel.getSheetAt(0);
            ListaPreciosDTO p = new ListaPreciosDTO();
            int last = hoja.getLastRowNum();
            for (int i = 2; i <= last; i++) {
                Row fila = hoja.getRow(i);
                p.setPagina((int) fila.getCell(0).getNumericCellValue());
                p.setMarca(fila.getCell(1).getStringCellValue());
                try {
                    p.setCodigo(fila.getCell(2).getStringCellValue());
                } catch (IllegalStateException ex) {
                    p.setCodigo(String.valueOf(fila.getCell(2).getNumericCellValue()));
                }
                p.setColor(fila.getCell(3).getStringCellValue());
                p.setPreciopublico(fila.getCell(4).getNumericCellValue());
                p.setPreciopromotor(fila.getCell(5).getNumericCellValue());
                grabar(p);
            }
            result = "Datos Importados Correctamente";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

