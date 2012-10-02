
package managedBean;

import entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import negocio.ProductoFacade;

@ManagedBean(name = "ProductoManejado")
@SessionScoped
public class ProductoManejado {
    @EJB
    private ProductoFacade productoFacade;
    private List<Producto> productos = new ArrayList<Producto>();
    private Producto producto = new Producto();

    public List<Producto> getProductos() {
        productos = productoFacade.getProductos();
        return productos;
    }
   
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
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

    public ProductoManejado() {
    }
}
