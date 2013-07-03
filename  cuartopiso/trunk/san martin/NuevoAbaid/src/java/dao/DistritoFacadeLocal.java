/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Distrito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorge
 */
@Local
public interface DistritoFacadeLocal {

    void create(Distrito distrito);

    void edit(Distrito distrito);

    void remove(Distrito distrito);

    Distrito find(Object id);

    List<Distrito> findAll();

    List<Distrito> findRange(int[] range);

    int count();
    
}
