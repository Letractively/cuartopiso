package dao;

import entidades.Profesion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProfesionFacadeLocal {

    void create(Profesion profesion);

    void edit(Profesion profesion);

    void remove(Profesion profesion);

    Profesion find(Object id);

    List<Profesion> findAll();

    List<Profesion> findRange(int[] range);

    int count();
    
    Profesion findByNombre(String nombre);
}
