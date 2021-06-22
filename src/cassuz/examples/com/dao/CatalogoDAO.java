package cassuz.examples.com.dao;

import cassuz.examples.com.Excepciones.ExcepcionCatalogo;
import cassuz.examples.com.beans.Catalogo;
import cassuz.examples.com.conexion.Conexion;
import cassuz.examples.com.interfaces.CatalogoInterface;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CatalogoDAO implements CatalogoInterface {
    private Connection cn;
    private CallableStatement stmt = null;

    public void ValidarCatalogo(String catalogos) throws ExcepcionCatalogo {
        List<Catalogo> list=listar();
        Optional<Catalogo> op=list.stream().filter(a->a.getNombre().equals(catalogos)).findFirst();
        if(op.isPresent()){
            JOptionPane.showMessageDialog(null,"Error. DNI ya Existente","Error",0);
        }

    }
    @Override
    public String grabar(Catalogo catalogo) {
        String result="";
        try {
            cn=Conexion.getConexion();
            stmt=cn.prepareCall("exec SP_C_CATALOGO ?,?,?");
            stmt.setString(1,catalogo.getNombre());
            stmt.setString(2,catalogo.getRepresentante());
            stmt.setString(3,catalogo.getTelefono());

            int f=stmt.executeUpdate();
            result="se afecto "+f+" filas";
            stmt.close();
            cn.close();
        } catch (SQLException throwables) {
            result=throwables.getMessage();
        }
        return result;
    }

    @Override
    public String modificar(Catalogo catalogo) {
        String result="";

        try {
            cn=Conexion.getConexion();
            stmt=cn.prepareCall("exec SP_U_CATALOGO ?,?,?,?");
            stmt.setInt(1,catalogo.getId());
            stmt.setString(2,catalogo.getNombre());
            stmt.setString(3,catalogo.getRepresentante());
            stmt.setString(4,catalogo.getTelefono());
            int f=stmt.executeUpdate();
            result="se afecto "+f+" filas";
            stmt.close();
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
            stmt=cn.prepareCall("exec SP_D_CATALOGO ?");
            stmt.setString(1,id.toString());
            int f=stmt.executeUpdate();
            result="Se afecto "+f+" filas";
            stmt.close();
            cn.close();
        }catch (SQLException ex) {
            result= ex.getMessage();
        }
        return result;
    }

    @Override
    public List<Catalogo> listar() {
        List<Catalogo> lista=new ArrayList<Catalogo>();
        try{
            cn=Conexion.getConexion();
            stmt=cn.prepareCall("exec SP_R_CATALOGO");
            ResultSet rs=stmt.executeQuery();
            Catalogo obj;
            while(rs.next()){
                obj=new Catalogo();
                obj.setId(rs.getInt("idcatalogo"));
                obj.setNombre(rs.getString("nomcatalogo"));
                obj.setRepresentante(rs.getString("reprecatalogo"));
                obj.setTelefono(rs.getString("telefcatalogo"));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

}
