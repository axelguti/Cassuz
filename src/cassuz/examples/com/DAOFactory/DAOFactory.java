package cassuz.examples.com.DAOFactory;

import cassuz.examples.com.dao.*;
import cassuz.examples.com.interfaces.*;


public class DAOFactory {
    public static DAOFactory getInstance(){
        return DAOFACTORYHOLDER.INSTANCE;
    }
    public static class DAOFACTORYHOLDER{
        private static final DAOFactory INSTANCE=new DAOFactory();
    }

    public static PromotorInterface getPromotorDAO(){
        return new PromotorDAO();
    }
    public static CatalogoInterface getCatalogoDAO(){return new CatalogoDAO();}
    public static UsuarioInterface getUsuarioDAO(){return new UsuarioDAO();}
    public static RolInterface getRolDAO(){return new RolDAO();}
    public static ListaPrecioInterface getListaPrecioDAO(){return new ListaPreciosDAO();}
    public static PedidoInterface getPedidoDAO(){return new PedidoDAO();}
}
