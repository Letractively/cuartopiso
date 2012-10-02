/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entidades.Productos;
import frontera.ProductosFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Aleatrix
 */
@ManagedBean(name="Olive")
@RequestScoped
public class Olive {
    @EJB
    private ProductosFacade productosFacade;
    private List<Productos> productos = new ArrayList<Productos>();
    private Productos producto;
    /** Creates a new instance of Olive */
    
    public Olive() {
    }

private List<String> images = new ArrayList<String>(); 
  
     
    public List<String> getImages() {  
        images.add("olive.jpg");  
        images.add("olive2.jpg");
        return images;  
    }

public List<Productos> getProductos() {
        productos = productosFacade.findAll();
        return productos;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }


}