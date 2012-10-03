package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Capra Franco
 * Clase encargada de conectarse a la DB y realizar consultas
 */
public class BaseDatos {
    
    private Connection conexion = null;
    private String user = "root";
    private String password = "";
    private String puerto = "3306";
    private String db = "facturador";
    private String host = "localhost";
    
    /*
     * Conexión a la DB
     */
    public Connection establececonexion(){
        if(conexion != null){
            return conexion;
        }
        try {
            // Se registra el Driver de MySQL
            Class.forName("com.mysql.jdbc.Driver");
            String urlConexion = "jdbc:mysql://" + host + ":" + puerto + "/" + db;
            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "root" por las
            // adecuadas a la base de datos que estemos usando.
            conexion = DriverManager.getConnection(urlConexion, user, password);
            
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al Conectarse a la Base de Datos");
        }
        
        return conexion;
    }
    
    /*
     * Cierra Conexión a la DB
     */
    public void cierraConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al Cerrar la Base de Datos");
        }
    }
    
    
}
