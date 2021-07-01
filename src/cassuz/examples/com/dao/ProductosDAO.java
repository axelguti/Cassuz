package cassuz.examples.com.dao;

import cassuz.examples.com.beans.Catalogo;
import cassuz.examples.com.beans.Productos;
import cassuz.examples.com.conexion.Conexion;
import cassuz.examples.com.interfaces.ProductoInterface;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductosDAO implements ProductoInterface {
    private Connection cn;
    private CallableStatement stm=null;
    @Override
    public String grabar(Productos productos) {
        String result="";
        try{
            cn= Conexion.getConexion();
            stm= Objects.requireNonNull(cn).prepareCall("exec SP_C_PRODUCTOS ?,?,?,?,?,?,?,?");
            stm.setInt(1,productos.getPagina());
            stm.setString(2,productos.getMarca());
            stm.setString(3,productos.getCodigo());
            stm.setString(4, productos.getColor());
            stm.setString(5,productos.getDescripcion());
            stm.setString(6, productos.getTalla());
            stm.setDouble(7,productos.getPrecio());
            stm.setString(8,productos.getCatalogo());
            int f=stm.executeUpdate();
            result="Registro Guardado";
            stm.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public String modificar(Productos productos) {
        String result="";
        try{
            cn=Conexion.getConexion();
            stm=cn.prepareCall("exec SP_U_PRODUCTO ?,?,?,?,?,?,?,?");
            stm.setInt(1,productos.getPagina());
            stm.setString(2,productos.getMarca());
            stm.setString(3,productos.getCodigo());
            stm.setString(4,productos.getColor());
            stm.setString(5,productos.getDescripcion());
            stm.setString(6,productos.getTalla());
            stm.setDouble(7,productos.getPrecio());
            stm.setString(8,productos.getCatalogo());
            int f=stm.executeUpdate();
            result="Registro Modificado";
            stm.close();
            cn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public String eliminar(Object id) {
        String result="";

        try{
            cn=Conexion.getConexion();
            stm=cn.prepareCall("exec SP_D_PRODUCTO ?");
            stm.setString(1,id.toString());
            stm.executeUpdate();
            result="Registro eliminado";
            stm.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Productos> listar() {
        List<Productos> listar=new ArrayList<>();
        try{
            cn=Conexion.getConexion();
            stm= Objects.requireNonNull(cn).prepareCall("exec SP_R_PRODUCTO");
            ResultSet rs= stm.executeQuery();
            Productos p;
            while (rs.next()){
                p=new Productos();
                p.setPagina(rs.getInt("pagproducto"));
                p.setMarca(rs.getString("marcaproducto"));
                p.setCodigo(rs.getString("codproducto"));
                p.setColor(rs.getString("colorproducto"));
                p.setDescripcion(rs.getString("Descripcion"));
                p.setTalla(rs.getString("talla"));
                p.setPrecio(rs.getDouble("precio"));
                p.setCatalogo(rs.getString("nomcatalogo"));
                listar.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listar;
    }
}
