package cassuz.examples.com.dao;

import cassuz.examples.com.beans.Rol;
import cassuz.examples.com.conexion.Conexion;
import cassuz.examples.com.interfaces.RolInterface;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolDAO implements RolInterface {
    private Connection cn;
    private CallableStatement stm=null;
    @Override
    public String grabar(Rol rol) {
        return null;
    }

    @Override
    public String modificar(Rol rol) {
        return null;
    }

    @Override
    public String eliminar(Object id) {
        return null;
    }

    @Override
    public List<Rol> listar() {
        List<Rol> listar=new ArrayList<>();
        try{
            cn= Conexion.getConexion();
            stm=cn.prepareCall("exec SP_R_ROLUSUARIO");
            ResultSet rs=stm.executeQuery();
            Rol r;
            while(rs.next()){
                r=new Rol();
                r.setIdrol(rs.getInt("idrol"));
                r.setNomrol(rs.getString("nomrol"));
                listar.add(r);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listar;
    }
}
