/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Interes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Almafuerte
 */
@Stateless
public class InteresFacade extends AbstractFacade<Interes> {
    @PersistenceContext(unitName = "creditoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InteresFacade() {
        super(Interes.class);
    }
    
}
