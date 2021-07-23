package cassuz.examples.com.dao;

import cassuz.examples.com.Excepciones.ExcepcionCatalogo;
import cassuz.examples.com.DTO.CatalogoDTO;
import cassuz.examples.com.conexion.Conexion;
import cassuz.examples.com.interfaces.CatalogoInterface;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CatalogoDAO implements CatalogoInterface {
    private Connection cn;
    private CallableStatement stmt = null;

    public void ValidarCatalogo(String catalogos) throws ExcepcionCatalogo {
        List<CatalogoDTO> list=listar();
        Optional<CatalogoDTO> op=list.stream().filter(a->a.getNombre().equals(catalogos)).findFirst();
        if(op.isPresent()){
            JOptionPane.showMessageDialog(null,"Error. DNI ya Existente","Error",0);
        }

    }
    @Override
    public String grabar(CatalogoDTO catalogoDTO) {
        String result="";
        try {
            cn=Conexion.getConexion();
            stmt= Objects.requireNonNull(cn).prepareCall("exec SP_C_CATALOGO ?,?,?,?");
            stmt.setString(1, catalogoDTO.getEstado());
            stmt.setString(2, catalogoDTO.getNombre());
            stmt.setString(3, catalogoDTO.getRepresentante());
            stmt.setString(4, catalogoDTO.getTelefono());

            int f=stmt.executeUpdate();
            result="se Registro exitosamente";
            stmt.close();
            cn.close();
        } catch (SQLException throwables) {
            result=throwables.getMessage();
        }
        return result;
    }

    @Override
    public String modificar(CatalogoDTO catalogoDTO) {
        String result="";

        try {
            cn=Conexion.getConexion();
            stmt= Objects.requireNonNull(cn).prepareCall("exec SP_U_CATALOGO ?,?,?,?,?");
            stmt.setInt(1, catalogoDTO.getId());
            stmt.setString(2, catalogoDTO.getEstado());
            stmt.setString(3, catalogoDTO.getNombre());
            stmt.setString(4, catalogoDTO.getRepresentante());
            stmt.setString(5, catalogoDTO.getTelefono());
            int f=stmt.executeUpdate();
            result="Se modifico exitosamente";
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
            stmt= Objects.requireNonNull(cn).prepareCall("exec SP_D_CATALOGO ?");
            stmt.setString(1,id.toString());
            int f=stmt.executeUpdate();
            result="Se elimino exitosamente";
            stmt.close();
            cn.close();
        }catch (SQLException ex) {
            result= ex.getMessage();
        }
        return result;
    }

    @Override
    public List<CatalogoDTO> listar() {
        List<CatalogoDTO> lista=new ArrayList<CatalogoDTO>();
        try{
            cn=Conexion.getConexion();
            stmt=cn.prepareCall("exec SP_R_CATALOGO");
            ResultSet rs=stmt.executeQuery();
            CatalogoDTO obj;
            while(rs.next()){
                obj=new CatalogoDTO();
                obj.setId(rs.getInt("idcatalogo"));
                obj.setEstado(rs.getString("estadocatalogo"));
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
