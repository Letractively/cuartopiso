
package dao;

import entidades.Distrito;
import entidades.Localidad;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DistritoFacadeLocal {

    void create(Distrito distrito);

    void edit(Distrito distrito);

    void remove(Distrito distrito);

    Distrito find(Object id);

    List<Distrito> findAll();

    List<Distrito> findRange(int[] range);

    int count();
    
    List<Distrito> findByLocalidad(Localidad localidad);   
    
}
