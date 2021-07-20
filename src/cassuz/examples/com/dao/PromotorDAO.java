package cassuz.examples.com.dao;




import cassuz.examples.com.DTO.PromotorDTO;
import cassuz.examples.com.conexion.Conexion;
import cassuz.examples.com.interfaces.PromotorInterface;
import cassuz.examples.com.Excepciones.ExcepcionDNI;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 *
 * @author PC
 */
public class PromotorDAO implements PromotorInterface {
    private Connection cn;
    private CallableStatement stn=null;

    public void ValidarDNI(String dni) throws ExcepcionDNI {
        List<PromotorDTO> list=listar();
        Predicate<PromotorDTO> pred=a->a.getDni().equals(dni);
        Optional<PromotorDTO> op=list.stream().filter(pred).findFirst();
        if(op.isPresent()){
            throw new ExcepcionDNI("Error: DNI ya existe");
        }

    }

    @Override
    public String grabar(PromotorDTO t) {
        String result="";
        try{
            cn=Conexion.getConexion();
            stn= Objects.requireNonNull(cn).prepareCall("exec SP_C_PROMOTOR ?,?,?,?,?,?,?,?");
            stn.setString(1, t.getDni());
            stn.setString(2, t.getNombre());
            stn.setString(3, t.getApellido());
            stn.setString(4,t.getDireccion());
            stn.setString(5,t.getTelefono());
            stn.setString(6, t.getFechaNacimiento().toString());
            stn.setString(7,t.getRecomendado());
            stn.setString(8,t.getFechaInscripcion().toString());
            stn.executeUpdate();
            result="Registro Agregado Satisfactoriamente";
            stn.close();
            cn.close();
        }catch(SQLException ex){
            result="Error: DNI ya existe";
        }
        return result;
    }

    @Override
    public String modificar(PromotorDTO t) {
        String result="";
        try {
            cn =Conexion.getConexion();
            stn=cn.prepareCall("exec SP_U_PROMOTOR ?,?,?,?,?,?,?");
            stn.setString(1, t.getDni());
            stn.setString(2, t.getNombre());
            stn.setString(3, t.getApellido());
            stn.setString(4,t.getDireccion());
            stn.setString(5,t.getTelefono());
            stn.setString(6, t.getFechaNacimiento().toString());
            stn.setString(7,t.getRecomendado());
            stn.executeUpdate();
            result="Registro Modificado Satisfactoriamente";
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
            stn.executeUpdate();
            result="Registro Eliminado Satisfactoriamente";
            stn.close();
            cn.close();
        }catch (SQLException ex) {
            result= ex.getMessage();
        }
        return result;
    }

    @Override
    public List<PromotorDTO> listar() {
        List<PromotorDTO> lista= new ArrayList<>();
        try{
            cn=Conexion.getConexion();
            stn= Objects.requireNonNull(cn).prepareCall("exec SP_R_PROMOTOR");
            ResultSet rs=stn.executeQuery();
            PromotorDTO obj;
            while(rs.next()){
                obj=new PromotorDTO(rs.getString("dnipromotor"),
                        rs.getString("nompromotor"),
                        rs.getString("apepromotor"),
                        rs.getString("direccpromotor"),
                        rs.getString("telefpromotor"),
                        LocalDate.parse(rs.getString("fechanacimiento")),
                        rs.getString("recomepromotor"),
                        LocalDate.parse(rs.getString("fechainscpromotor")));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public PromotorDTO buscar(Object id) {
        PromotorDTO obj=null;
        try {
            cn=Conexion.getConexion();
            stn= Objects.requireNonNull(cn).prepareCall("exec SP_B_PROMOTOR ?");
            stn.setString(1,id.toString());
            ResultSet rs= stn.executeQuery();
            while(rs.next()){
                obj=new PromotorDTO();
                obj.setNombre(rs.getString("nompromotor"));
                obj.setApellido(rs.getString("apepromotor"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }
}
