
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;


/*
 * TableVideojuegoPojo es la clase encargada de solicitar la lista de videojuegos
 * al DAO, mediante el método getListaVideojuegos
 */
@ManagedBean
public class TableVideojuegoPojo implements Serializable {    

    //Atributo listaVidejojuegos: Contiene la lista de videojuegos existentes
    // en la base de datos.
    private List<VideojuegoPojo> listaVideojuegos;


    /*
     * Método getListaVideojuegos: Invoca el método getListaJuegos() de la clase
     * Dao para obtener la lista de videojuegos, cuyo valor se guarda en
     * listaVideojuegos.
     */
    public List<VideojuegoPojo> getListaVideojuegos() {
        listaVideojuegos = Dao.getListaJuegos();
        return listaVideojuegos;
    }
}
