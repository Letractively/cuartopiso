/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author pablonello
 */
@Stateless
@LocalBean
public class Bean {

    public String DigaHola(String nombre) {
        return "hola  " + nombre;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
