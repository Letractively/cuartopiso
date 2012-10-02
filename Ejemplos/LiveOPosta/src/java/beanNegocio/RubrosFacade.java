/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beanNegocio;

import entidades.Rubro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alumno
 */
@Stateless
public class RubrosFacade extends AbstractFacade<Rubro> {
    @PersistenceContext(unitName = "LiveOPostaPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public RubrosFacade() {
        super(Rubro.class);
    }

}
