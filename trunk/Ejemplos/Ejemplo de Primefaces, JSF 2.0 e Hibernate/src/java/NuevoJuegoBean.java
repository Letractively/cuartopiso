import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;


/*******************************************************************************
 * Class NuevoJuegoBean:                                                       *
 * Descripción: En esta clase se van rellenando los atributos de un videojuego *
 * (nombre, sinapsis, ruta y precio) introducidos por el usuario en el         *
 * formulario                                                                  *
 * ****************************************************************************/

@ManagedBean
@ViewScoped
public class NuevoJuegoBean {

    private String nombre;
    private String sinapsis;
    private float precio;
    private String ruta;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSinapsis(String sinapsis) {
        this.sinapsis = sinapsis;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void serRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombre(){
        return nombre;
    }

    public String getSinapsis(){
        return sinapsis;
    }

    public float getPrecio(){
        return precio;
    }

    public String getRuta(){
        return ruta;
    }

    /*
     * Método grabarJuego: Este método ejecuta una llamada a
     * Dao.introducirVideojuegoPojo pasándole los atributos
     * nombre, ruta, sinapsis y precio que son propios de esta clase.
     */
    public void grabarJuego() {
        Dao.introducirVideojuegoPojo(nombre,ruta,sinapsis,precio);
    }

    public void accionFileUpload (FileUploadEvent event) {
        UploadedFile file = event.getFile();
        ruta = file.getFileName();
        Dao.gestionarFotoSubida(file.getContents(), ruta);
    }

}
