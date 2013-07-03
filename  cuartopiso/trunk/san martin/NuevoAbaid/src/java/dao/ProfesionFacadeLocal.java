/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Profesion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorge
 */
@Local
public interface ProfesionFacadeLocal {

    void create(Profesion profesion);

    void edit(Profesion profesion);

    void remove(Profesion profesion);

    Profesion find(Object id);

    List<Profesion> findAll();

    List<Profesion> findRange(int[] range);

    int count();
    
}
