package cassuz.examples.com.dao;

import cassuz.examples.com.Excepciones.ExcepcionUsuario;
import cassuz.examples.com.beans.Usuario;
import cassuz.examples.com.conexion.Conexion;
import cassuz.examples.com.interfaces.UsuarioInterface;
import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UsuarioDAO implements UsuarioInterface {

    private Connection cn;
    private CallableStatement stm=null;

    public void ValidarUsuario(String dni) throws ExcepcionUsuario {
        List<Usuario> list=listar();
        Optional<Usuario> op=list.stream().filter(a->a.getUsuarioUsuario().equals(dni)).findFirst();
        if(op.isPresent()){
            throw new ExcepcionUsuario("Error: Usuario ya existe");
        }

    }

    @Override
    public String grabar(Usuario usuario) {
        String result = "";

        try{
            cn= Conexion.getConexion();
            stm= Objects.requireNonNull(cn).prepareCall("exec SP_C_USUARIO ?,?,?,?,?,?");
            stm.setString(1,usuario.getNomUsuario());
            stm.setString(2,usuario.getApeUsuario());
            stm.setString(3, usuario.getTelefUsuario());
            stm.setString(4,usuario.getUsuarioUsuario());

            stm.setString(5,usuario.getContraUsuario());
            stm.setString(6,usuario.getRolUsuario());
            int f=stm.executeUpdate();
            result="se afecto "+ f + " filas";
            stm.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public String modificar(Usuario usuario) {
        String result = "";

        try{
            cn=Conexion.getConexion();
            stm= cn.prepareCall("exec SP_U_USUARIO ?,?,?,?,?,?");
            stm.setString(1,usuario.getNomUsuario());
            stm.setString(2, usuario.getApeUsuario());
            stm.setString(3,usuario.getTelefUsuario());
            stm.setString(4,usuario.getUsuarioUsuario());
            stm.setString(5,usuario.getContraUsuario());
            stm.setString(6,usuario.getRolUsuario());
            int f=stm.executeUpdate();
            result="se afecto "+ f + " filas";
            stm.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    @Override
    public String eliminar(Object id) {
        String result = "";

        try{
            cn=Conexion.getConexion();
            stm=cn.prepareCall("exec SP_D_USUARIO ?");
            stm.setString(1,id.toString());
            int f=stm.executeUpdate();
            result="se afecto " + f+ " filas";
            stm.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> lista= new ArrayList<>();
        try {
            cn=Conexion.getConexion();
            stm= Objects.requireNonNull(cn).prepareCall("exec SP_R_USUARIO");
            ResultSet rs=stm.executeQuery();
            Usuario user;
            while(rs.next()){
                user=new Usuario(rs.getString("usuariosusuario"),
                        rs.getString("contrausaurio"));
                user.setNomUsuario(rs.getString("nomusuario"));
                user.setApeUsuario(rs.getString("apeusuario"));
                user.setTelefUsuario(rs.getString("telefusuario"));
                user.setRolUsuario(rs.getString("nomrol"));
                lista.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }

}
