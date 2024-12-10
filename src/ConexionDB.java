import java.sql.*;

public class ConexionDB {
    
    private String URL = "jdbc:mysql://localhost:3306/agenda-contacto";
    private String user = "root";
    private String pass = "";
    private Connection connection;

    public ConexionDB() {
        
    }

    public Connection conectar() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL, user, pass);
        return connection;
    }

    public Connection desconectar() throws Exception {
         try {
             if (connection != null && !connection.isClosed()) {
                 connection.close();
                 System.out.println();
                 System.out.println("Conexión cerrada correctamente.");
             }
         } catch (Exception e) {
             e.printStackTrace();
      }
      return connection;
     }  
}




