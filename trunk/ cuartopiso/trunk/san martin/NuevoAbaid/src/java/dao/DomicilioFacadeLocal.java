/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Domicilio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorge
 */
@Local
public interface DomicilioFacadeLocal {

    void create(Domicilio domicilio);

    void edit(Domicilio domicilio);

    void remove(Domicilio domicilio);

    Domicilio find(Object id);

    List<Domicilio> findAll();

    List<Domicilio> findRange(int[] range);

    int count();
    
}
