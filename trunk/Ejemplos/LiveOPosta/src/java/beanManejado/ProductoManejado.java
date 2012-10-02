/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beanManejado;

import beanNegocio.ProductoFacade;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Alumno
 */
@ManagedBean(name="ProductoManejado")
@RequestScoped
public class ProductoManejado {
    @EJB
    private ProductoFacade productoFacade;
    private Producto producto;
    private String rubroValor;
    private List<Producto> productos;
    private List<String> images = new ArrayList<String>();
    /** Creates a new instance of ProductoManejado */
    
    public ProductoManejado() {
        producto = new Producto();
        productos = new ArrayList<Producto>();
    }
    
    public List<Producto> buscarTodosLosProductos() {
        productos = productoFacade.findAll();
        return productos;
    }

    public String getRubroValor() {
        return rubroValor;
    }

    public void setRubroValor(String rubroValor) {
        this.rubroValor = rubroValor;
    } 
    
    public List<String> getImages() {
        images.add("ImagenG1.jpg");
        images.add("ImagenG2.jpg");
        return images;
    }

    public String irIndex(){
        return "index";
    }
    
public List<Producto> buscarPorRanking() {
       productos = productoFacade.buscarPorRanking(1);
        return productos;
   }
public List<Producto> buscarPorRubro() {
        
        productos = productoFacade.buscarPorRubro(rubroValor);
        return productos;
}

public List<Producto> buscarPorProveedor() {
//        productos = productoFacade.buscarPorMarca("a");
        return productos;
    }




   

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }


}
