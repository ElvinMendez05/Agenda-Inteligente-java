import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDB {
    private ConexionDB db;
    private Connection connection;    
    
    public AdminDB(ConexionDB db) {
          this.db = db;
     }

    public List<Contactos> mostrar() {
          
      List<Contactos> listContactos = new ArrayList<Contactos>();

    try { 
      connection = db.conectar();
       String query = "SELECT id, nombre, apellido, correo, telefono, empresa FROM contactos";

        Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
           Contactos contactos = new Contactos(
             resultSet.getInt("id"), 
             resultSet.getString("nombre"),
             resultSet.getString("apellido"),  
             resultSet.getString("correo"), 
             resultSet.getString("telefono"), 
             resultSet.getString("empresa")
            );
        
            listContactos.add(contactos);
        }

      } catch(Exception e) {
         e.printStackTrace();
      }
       
       return listContactos;
    }

    public void insertar(Contactos contactos) {
      try {
        connection = db.conectar();
        String query = "INSERT INTO contactos(nombre, apellido, correo, telefono, empresa) " + 
              " VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement pStatement = connection.prepareStatement(query);
        
        pStatement.setString(1, contactos.getNombre());
        pStatement.setString(2, contactos.getApellido());
        pStatement.setString(3, contactos.getCorreo());
        pStatement.setString(4, contactos.getTelefono());
        pStatement.setString(5, contactos.getEmpresa());
        
        pStatement.execute();
        System.out.println("Se ha guardado el contacto correctamente.");
        pStatement.execute();

      } catch (Exception e) {
         e.printStackTrace();
      }
    }

    public void actualizar(Contactos contactos) {
        try {
            connection = db.conectar();
            String query = "UPDATE contactos SET nombre = ?, apellido = ?, correo = ?, telefono = ?, empresa = ? WHERE id = ?";
            
            PreparedStatement pStatement = connection.prepareStatement(query);

            pStatement.setString(1, contactos.getNombre());
            pStatement.setString(2, contactos.getApellido());
            pStatement.setString(3, contactos.getCorreo());
            pStatement.setString(4, contactos.getTelefono());
            pStatement.setString(5, contactos.getEmpresa());
            pStatement.setInt(6, contactos.getId());
            
            pStatement.executeUpdate();
            System.out.println("Se ha actualizado el contacto correctamente.");
   
          } catch (Exception e) {
             e.printStackTrace();
          }
      }

    public void eliminar(Contactos contactos) {
       
      try {
          connection = db.conectar();
          String query = "DELETE FROM contactos WHERE id = ?";
          
          PreparedStatement pStatement = connection.prepareStatement(query);

          pStatement.setInt(1, contactos.getId());
          
          pStatement.execute();

          System.out.println("Se ha eliminado el contacto correctamente.");

        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    public boolean comprobarID(int valor){
      boolean existe = false;
      try{
      connection = db.conectar();
      String query = "SELECT COUNT(*) FROM contactos WHERE id = ?";
      
      
      PreparedStatement pStatement = connection.prepareStatement(query);
      pStatement.setInt(1, valor);
      
      try (ResultSet resultSet = pStatement.executeQuery()) {
          if (resultSet.next()) {
              int conteo = resultSet.getInt(1);
              if (conteo > 0) {
                  existe = true;
              } else {
                  existe = false;
              }
          }
          
      } catch (Exception e) {
          e.printStackTrace();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      return existe;
}

public void cerrar(){
  try {
    db.desconectar();
  } catch (Exception e) {
    e.printStackTrace();
  }
}

}