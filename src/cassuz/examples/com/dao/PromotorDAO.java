package cassuz.examples.com.dao;




import cassuz.examples.com.beans.Promotor;
import cassuz.examples.com.conexion.Conexion;
import cassuz.examples.com.interfaces.PromotorInterface;
import cassuz.examples.com.Excepciones.ExcepcionDNI;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author PC
 */
public class PromotorDAO implements PromotorInterface {
    private Connection cn;
    private CallableStatement stn=null;

    public void ValidarDNI(String dni) throws ExcepcionDNI {
        List<Promotor> list=listar();
        Optional<Promotor> op=list.stream().filter(a->a.getDni().equals(dni)).findFirst();
        if(op.isPresent()){
            throw new ExcepcionDNI("Error: DNI ya existe");
        }

    }

    @Override
    public String grabar(Promotor t) {
        String result="";
        try{
            cn=Conexion.getConexion();
            stn= Objects.requireNonNull(cn).prepareCall("exec SP_C_PROMOTOR ?,?,?,?,?,?,?,?");
            stn.setString(1, t.getDni());
            stn.setString(2, t.getNombre());
            stn.setString(3, t.getApellido());
            stn.setString(4,t.getDireccion());
            stn.setString(5,t.getTelefono());
            stn.setString(6, t.getCorreo());
            stn.setString(7,t.getRecomendado());
            stn.setString(8,t.getFechaNacimiento().toString());
            int f=stn.executeUpdate();
            result="se afecto "+f+" filas";
            stn.close();
            cn.close();
        }catch(SQLException ex){
            result=ex.getMessage();
        }
        return result;
    }

    @Override
    public String modificar(Promotor t) {
        String result="";
        try {
            cn =Conexion.getConexion();
            stn=cn.prepareCall("exec SP_U_PROMOTOR ?,?,?,?,?,?,?");
            stn.setString(1, t.getDni());
            stn.setString(2, t.getNombre());
            stn.setString(3, t.getApellido());
            stn.setString(4,t.getDireccion());
            stn.setString(5,t.getTelefono());
            stn.setString(6, t.getCorreo());
            stn.setString(7,t.getRecomendado());
            int f=stn.executeUpdate();
            result="Se afecto "+f+" filas";
            stn.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public String eliminar(Object id) {
        String result="";
        try {
            cn=Conexion.getConexion();
            stn=cn.prepareCall("exec SP_D_PROMOTOR ?");
            stn.setString(1,id.toString());
            int f=stn.executeUpdate();
            result="Se afecto"+f+"filas";
            stn.close();
            cn.close();
        }catch (SQLException ex) {
            result= ex.getMessage();
        }
        return result;
    }

    @Override
    public List<Promotor> listar() {
        List<Promotor> lista= new ArrayList<>();
        try{
            cn=Conexion.getConexion();
            stn= Objects.requireNonNull(cn).prepareCall("exec SP_R_PROMOTOR");
            ResultSet rs=stn.executeQuery();
            Promotor obj;
            while(rs.next()){
                obj=new Promotor(rs.getString("dnipromotor"),
                        rs.getString("nompromotor"),
                        rs.getString("apepromotor"),
                        rs.getString("direccpromotor"),
                        rs.getString("telefpromotor"),
                        rs.getString("correopromotor"),
                        rs.getString("recomepromotor"),
                        LocalDate.parse(rs.getString("fechainscpromotor")));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
