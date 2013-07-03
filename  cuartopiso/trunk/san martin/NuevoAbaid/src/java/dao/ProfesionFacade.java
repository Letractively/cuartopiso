/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Profesion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorge
 */
@Stateless
public class ProfesionFacade extends AbstractFacade<Profesion> implements ProfesionFacadeLocal {
    @PersistenceContext(unitName = "NuevoAbaidPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfesionFacade() {
        super(Profesion.class);
    }
    
}
