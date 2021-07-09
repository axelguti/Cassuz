package cassuz.examples.com.dao;

import cassuz.examples.com.DTO.PedidosDTO;
import cassuz.examples.com.conexion.Conexion;
import cassuz.examples.com.interfaces.PedidoInterface;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PedidoDAO implements PedidoInterface {

    private Connection cn;
    private CallableStatement stm=null;

    @Override
    public String grabar(PedidosDTO pedidosDTO) {
        String result = "";

        try{
            cn= Conexion.getConexion();
            stm = Objects.requireNonNull(cn).prepareCall("EXEC SP_C_PEDIDO ?,?,?,?,?,?,?,?,?");
            stm.setString(1, pedidosDTO.getDniPromotor());
            stm.setString(2, pedidosDTO.getNomCatalogo());
            stm.setString(3, pedidosDTO.getCodProducto());
            stm.setString(4, pedidosDTO.getMarca());
            stm.setInt(5, pedidosDTO.getPagina());
            stm.setString(6, pedidosDTO.getColor());
            stm.setString(7, pedidosDTO.getTalla());
            stm.setDouble(8, pedidosDTO.getPrecio());
            stm.setString(9, pedidosDTO.getFechaPedido().toString());
            stm.executeUpdate();
            result="Pedido Registrado Exitosamente";
            stm.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    @Override
    public String modificar(PedidosDTO pedidosDTO) {
        return null;
    }

    @Override
    public String eliminar(Object id) {
        return null;
    }

    @Override
    public List<PedidosDTO> listar() {
        List<PedidosDTO> listar=new ArrayList<>();

        try{
            cn=Conexion.getConexion();
            stm=Objects.requireNonNull(cn).prepareCall("exec SP_R_PEDIDO");
            ResultSet rs=stm.executeQuery();
            PedidosDTO p;
            while(rs.next()){
                p=new PedidosDTO();
                p.setIdPedido(rs.getInt("idpedido"));
                p.setDniPromotor(rs.getString("dnipromotor"));
                p.setNombrepromotor(rs.getString("nompromotor"));
                p.setApepromotor(rs.getString("apepromotor"));
                p.setNomCatalogo(rs.getString("nomcatalogo"));
                p.setPagina(Integer.parseInt(rs.getString("pagcatalogo")));
                p.setCodProducto(rs.getString("codproducto"));
                p.setMarca(rs.getString("marcaproducto"));
                p.setColor(rs.getString("colorproducto"));
                p.setTalla(rs.getString("tallaproducto"));
                p.setPrecio(rs.getDouble("precioproducto"));
                p.setFechaPedido(LocalDate.parse(rs.getString("fechapedido")));
                listar.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listar;
    }
}
