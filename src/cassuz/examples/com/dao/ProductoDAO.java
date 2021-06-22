package cassuz.examples.com.dao;

import cassuz.examples.com.beans.Productos;
import cassuz.examples.com.conexion.Conexion;
import cassuz.examples.com.interfaces.ProductoInterface;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductoDAO implements ProductoInterface {
    private Connection cn;
    private CallableStatement stm=null;
    @Override
    public String grabar(Productos productos) {
        String result="";
            try {
                cn=Conexion.getConexion();
                stm=cn.prepareCall("exec SP_C_PRODUCTO ?,?,?,?,?,?");
                stm.setInt(1,productos.getPagina());
                stm.setString(2,productos.getMarca());
                stm.setString(3, productos.getCodigo());
                stm.setString(4, productos.getColor());
                stm.setString(5, String.valueOf(productos.getPreciopublico()));
                stm.setString(6, String.valueOf(productos.getPreciopromotor()));
                int f= stm.executeUpdate();
                result="se afecto "+ f +" filas";
                stm.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        return result;
    }

    @Override
    public String modificar(Productos productos) {
        return null;
    }

    @Override
    public String eliminar(Object id) {
        return null;
    }

    @Override
    public List<Productos> listar() {
        List<Productos> listar = new ArrayList<>();
        try{
            cn=Conexion.getConexion();
            stm=cn.prepareCall("SP_R_PRODUCTO");
            ResultSet rs=stm.executeQuery();
            Productos obj;
            while(rs.next()){
                obj=new Productos();
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
    public List<Productos> Importar(Class<Productos> producto, String file) {
        // Prepara una lista para almacenar los resultados
        List<Productos> list=new ArrayList<>();

        HSSFWorkbook workbook= null;
        try {
            // Crear un libro de trabajo por ruta de archivo
            workbook = new HSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            System.out.println(e.getMessage());
        }

        // Obtenga la primera forma de hoja del excel actual
        HSSFSheet sheet = workbook.getSheetAt(0);

        // Obtenga la primera fila de la tabla de Excel para obtener los nombres de campo de la tabla
        HSSFRow tempRow = sheet.getRow(0);

        // Obtener el número total de filas
        int lastRowNum = sheet.getLastRowNum();

        // atraviesa la línea que comienza desde la segunda línea
        for (int i = 1; i <= lastRowNum; i++) {
            HSSFRow row = sheet.getRow(i);

            // Obtener el número de columnas
            int cells = row.getPhysicalNumberOfCells();

            // Instanciar el objeto de clase de entidad
            Productos tempT= null;
            try {
                tempT = producto.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            // Iterar a través de cada columna de la fila actual
            for (int j = 0; j < cells; j++) {
                // El valor de la columna actual
                HSSFCell hsscell = row.getCell(j);
                // El nombre de la columna actual
                HSSFCell cellName= tempRow.getCell(j);

                Field field = null;
                try {
                    // Obtenga el atributo correspondiente a la clase de entidad de acuerdo con el nombre de la columna
                    field =tempT.getClass().getDeclaredField(cellName.toString());
                } catch (NoSuchFieldException e) {
                    System.out.println(field.getName()+"Error al obtener los atributos");
                    System.out.println(e.getMessage());
                }

                // Omitir si el campo está vacío
                if (hsscell==null){
                    continue;
                }

                try {
                    // Establecer el valor de acuerdo con el tipo de datos obtenidos de Excel
                    if (field!=null){
                        // Autorización de propiedad privada
                        field.setAccessible(true);
                        if (hsscell.getCellType()== CellType.NUMERIC){
                            if(HSSFDateUtil.isCellDateFormatted(hsscell)){// fecha
                                if (field.getType()== Date.class){
                                    field.set(tempT,hsscell.getDateCellValue());
                                }
                            }else if(field.getType()==Integer.class){
                                // tipo int
                                field.set(tempT,Integer.valueOf(hsscell.getStringCellValue()));
                            }else if(field.getType()==Double.class){
                                // tipo doble
                                field.set(tempT,Double.parseDouble(hsscell.toString()) );
                            }
                        }else if (hsscell.getCellType()==CellType.BOOLEAN){
                            // valor booleano
                            if (field.getType()==Boolean.class){
                                field.set(tempT,hsscell.getBooleanCellValue() );
                            }
                        }else if(hsscell.getCellType()==CellType.STRING){
                            if (field.getType()==Integer.class){
                                field.set(tempT,Integer.parseInt(hsscell.toString()));
                            }else if (field.getType()==Double.class){
                                field.set(tempT,Double.valueOf(hsscell.toString()) );
                            }else if (field.getType()==String.class){
                                field.set(tempT,hsscell.toString() );
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    System.out.println(field.getName()+"Configuración fallida");
                    e.printStackTrace();
                }
            }
            // Añadir a la colección de la lista
            list.add(tempT);
        }
        // Devuelve la colección de lista encapsulada
        return list;
    }
}

