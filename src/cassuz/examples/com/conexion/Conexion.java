package cassuz.examples.com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion(){
        String url="jdbc:sqlserver://IRMA\\MSSQLSERVER01:1433;" +
                "database=BDCASSUZ;user=Axl;password=1234;";
        try{
            Connection con=DriverManager.getConnection(url);
            return con;

        }catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
}
