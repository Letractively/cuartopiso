import javax.faces.bean.ManagedBean;


/*
 * Esta es una clase POJO. Cargaremos los valores de los campos de la tabla
 * juegos en los atributos de esta clase.
 */

@ManagedBean
public class VideojuegoPojo{

    
    private int id;
    private String nombre;
    private String ruta;
    private String sinapsis;
    private float precio;


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public String getSinapsis() {
        return sinapsis;
    }

    public float getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id=id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setRuta(String ruta) {
        this.ruta=ruta;
    }

    public void setSinapsis(String sinapsis) {
        this.sinapsis = sinapsis;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
