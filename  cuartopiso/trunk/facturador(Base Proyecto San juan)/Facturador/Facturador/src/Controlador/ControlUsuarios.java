
package Controlador;

import Conexion.BaseDatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Modelo.Usuario;

/**
 *
 * @author Capra Franco
 */
public class ControlUsuarios {
    
    BaseDatos DB = new BaseDatos();
    Connection cnx = DB.establececonexion();
    
    
    /*
     * Valida en la BD si el usuario es correcto
     */
    public boolean ValidaUsuario(String usr, String psw){
        ResultSet rs = null;
        
        try {
            String pswEncriptada = SHA1.SHA1(psw);
            System.out.println("Clave Enc: "+pswEncriptada);
            
            PreparedStatement ps = cnx.prepareStatement(""
                    + "SELECT * FROM usuario "
                    + "WHERE usr = ? AND psw = ?");
            ps.setString(1, usr);
            ps.setString(2, pswEncriptada);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Login");
            return false;
        }
    }
    
 
    
    /*
     * Agregar usuarios a la BD
     */
    public boolean InsertaUsuario(String usr,String psw,String nom,String ape,Object cat){
        
        try {
            
            String pswEncriptada = SHA1.SHA1(psw);
            System.out.println("Clave Enc: "+pswEncriptada);
            
            Calendar ahora = Calendar.getInstance();
            int mes = ahora.get(Calendar.MONTH) + 1;
            int dia = ahora.get(Calendar.DAY_OF_MONTH);
            int year = ahora.get(Calendar.YEAR);
            
            String fec = year + "-" + mes + "-" + dia;
            
            PreparedStatement ps = cnx.prepareStatement(""
                    + "INSERT INTO usuario (usr,psw,nombre,apellido,categoria,fecha)"
                    + " VALUES (?,?,?,?,?,?)");
            ps.setString(1, usr);
            ps.setString(2, pswEncriptada);
            ps.setString(3, nom);
            ps.setString(4, ape);
            ps.setObject(5, cat);
            ps.setString(6, fec );
            
            int n = ps.executeUpdate();
            
            if(n > 0){
                JOptionPane.showMessageDialog(null, "Usuario Registrado Correctamente");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Error al Registrar Usuario");
                return false;
            }
            
            
        } catch (Exception e) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    /*
     * Agregar Empresas a la BD
     */
    public boolean AgregaEmpresa(Long nom,String cui,Long tel,String fac){
        
        try {
            
            PreparedStatement ps = cnx.prepareStatement(""
                    + "INSERT INTO empresas (nom,cui,tel,fac)"
                    + " VALUES (?,?,?,?)");
            ps.setLong(1, nom);
            ps.setString(2, cui);
            ps.setLong(3, tel);
            ps.setString(4, fac);
            
            int n = ps.executeUpdate();
            
            if(n > 0){
                JOptionPane.showMessageDialog(null, "Empresa Registrada Correctamente");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Error al Registrar Empresa");
                return false;
            }
            
            
        } catch (Exception e) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    
}
