/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Conexion.BaseDatos;
import Modelo.Stock;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class GestorStock {
     
    BaseDatos DB = new BaseDatos();
    Connection cnx = DB.establececonexion();
    
      public void cerrarConexion() {
        try {
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
      public List<Stock> dameListaStock() {
        ResultSet rs = null;
        Stock sto = new Stock();
        List<Stock> list = new ArrayList<Stock>();

        try {
            // Se crea un Statement, para realizar la consulta
            Statement s = cnx.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery("select * from articulos");
            while (rs.next()) {
                sto = new Stock();
                sto.setSector(rs.getInt("sec"));
                sto.setArt(rs.getInt("art"));
                sto.setDescripcion(rs.getString("descripcion"));
                sto.setPrecio(rs.getFloat("precio"));
                sto.setStock(rs.getInt("stock"));
                list.add(sto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
      }
}
      
      /*
      public void insertarStock(String sec, String art, String descripcion, String precio, String stock) {
        try {
            
                // Se crea el objeto PreparedStatement.
                // Este precompila la sentencia SQL especificada.
                // Los signos de interrogación señalan el lugar en que deben establecerse los
                // parámetros antes de que se ejecute la sentencia.
                PreparedStatement ps = cnx.prepareStatement("INSERT INTO articulos (sec, art, descripcion, precio, stock) VALUES (?, ?, ?, ?, ?)");

                // Se establecen los parámetros y se ejecuta la sentencia.
                ps.setInt(1, new Integer(sec));
                ps.setLong(2, new Long(art));
                ps.setString(3, descripcion);
                ps.setDouble(4, new Double(precio));
                ps.setInt(5, new Integer(stock));
                ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
     
      
      
       public Stock dameStockFila(Long idFila) {
        ResultSet rs = null;
        Stock sto = new Stock();
        try {
            // Se crea un Statement, para realizar la consulta
            Statement s = cnx.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery("select * from articulos where id = " + idFila);
            if (rs.next()) {
                sto.setSector(rs.getString("sec"));
                sto.setArt(rs.getLong("art"));
                sto.setDescripcion(rs.getString("descripcion"));
                sto.setPrecio(rs.getDouble("precio"));
                sto.setStock(rs.getInt("stock"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sto;
    }
}
*/