package negocio;

import entidades.Cliente;
import entidades.Distrito;
import entidades.Localidad;
import entidades.Profesion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GestorListasLocal {

    List<Localidad> localidades();

    List<Distrito> distritos();

    List<Profesion> profesiones();
    
    List<Distrito> buscarDistritos(Localidad idLocalidad);
    
    List<Cliente> clientes();
    
    Localidad getLocalidad(String localidad);
}
