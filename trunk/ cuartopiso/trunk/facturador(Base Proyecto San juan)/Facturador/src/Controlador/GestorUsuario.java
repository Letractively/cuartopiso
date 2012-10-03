/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.BaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Usuario;
/**
 *
 * @author pablo
 */
public class GestorUsuario {
   BaseDatos DB = new BaseDatos();
    Connection cnx = DB.establececonexion();
    
     public void cerrarConexion() {
        try {
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public List<Usuario> dameListaUsuarios() {
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            // Se crea un Statement, para realizar la consulta
            Statement s = cnx.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery("select * from usuario");
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setUsr(rs.getString("usr"));
                usuario.setPsw(rs.getString("pswEncriptada"));
                usuario.setNombre(rs.getString("nom"));
                usuario.setApellido(rs.getString("ape"));
                usuario.setCategoria(rs.getObject("cat"));
                usuario.setFecha(rs.getString("fec"));
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
