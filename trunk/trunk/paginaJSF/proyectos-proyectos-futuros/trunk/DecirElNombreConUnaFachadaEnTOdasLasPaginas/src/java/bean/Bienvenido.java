/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;




/**
 *
 * @author pablonello
 */
@ManagedBean
@RequestScoped
public class Bienvenido {
    private String nombre;
    private String mensaje;

    public String getMensaje() {
        return "hola " + nombre;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
