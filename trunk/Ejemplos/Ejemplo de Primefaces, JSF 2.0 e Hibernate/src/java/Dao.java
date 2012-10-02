import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import org.hibernate.Criteria;
import org.hibernate.Session;

/*******************************************************************************
 * Class Dao:                                                          *
 * Descripción: Esta clase es la encargada de introducir y servir los datos    *
 * presentes en la base de datos, así como de guardar las imagenes en          *
 * la ruta contenida en carpetaFisica. DAO                                     *
 * ****************************************************************************/


@ManagedBean
public class Dao {

    // Constante carpeta: Directorio virtual en donde estarán las fotos subidas
    // de los videojuegos.
    private static final String carpeta ="/Imagenes/";

    //Constante carpetaFisica: Carpeta física del ordenador donde se van a guardar
    // las fotos subidas de los videojuegos.
    private static final String carpetaFisica = "C:\\Users\\Alberto\\Documents\\NetBeansProjects\\Gamer\\build\\web\\Imagenes\\";

    //Método getCarpeta(): getter del atributo carpeta.
    //Parámetros de salida: Atributo carpeta.
    public String getCarpeta() {
        return carpeta;
    }

    protected void finalize () {
        ConfHibernate.getSessionFactory().close();
    }

    /*
     * Método getListaJuegos.
     * Descripción: Devuelve una lista de VideojuegoPojo, que contiene todos
     * los videojuegos que hay en la base de datos.
     */
    static List<VideojuegoPojo> getListaJuegos() {
        List<VideojuegoPojo> listaJuegos = new ArrayList<VideojuegoPojo>();
        Session session = ConfHibernate.getSessionFactory().getCurrentSession();        
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(VideojuegoPojo.class);
            listaJuegos = criteria.list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,"Problema al obtener la lista de Juegos");
            session.getTransaction().rollback();
        }
        return listaJuegos;
    }

    /*
     * Método introducirVideojuegoPojo.
     * Descripción: Método de clase, que se encarga de introducir los datos
     * de un videojuego en la base de datos.
     * Parámetros de entrada: Nombre, ruta, sinapsis y precio del videojuego a introducir
     */
    public static void introducirVideojuegoPojo(String nombre, String ruta, String sinapsis, float precio) {                
        Session session = ConfHibernate.getSessionFactory().getCurrentSession();
        VideojuegoPojo miVideojuego = new VideojuegoPojo();        
        miVideojuego.setNombre(nombre);
        miVideojuego.setRuta(ruta);
        miVideojuego.setSinapsis(sinapsis);
        miVideojuego.setPrecio(precio);
        try {
            session.beginTransaction();
            session.save(miVideojuego);
            session.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,"Problema guardar el juego nuevo");
            session.getTransaction().rollback();
        }
    }

    /*
     * Método gestionarFotoSubida.
     * Descripción: Método de clase que se encarga de copiar el array de bytes entrante
     * en un fichero fisico con el nombre que le llega de entrada, en la carpeta
     * física apuntada por la constante de clase carpetaFisica.
     * Parámetros de entrada: 1) Array de bytes correspondientes a la imagen
     * a guardar. 2) nombre que tiene que tener la imagen.
     */
    public static void gestionarFotoSubida(byte[] datos, String nombre) {
        File file = new File(carpetaFisica+nombre);
        try {
            file.createNewFile();
            FileOutputStream fout = new FileOutputStream(file);
            fout.write(datos);
            fout.close();
        } catch (IOException ex) {            
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Carpeta: "+System.getProperty("user.dir")+"/"+carpeta+"/"+nombre);
        }
    }


}
