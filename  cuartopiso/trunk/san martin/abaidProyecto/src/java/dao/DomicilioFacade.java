/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Domicilio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pablo
 */
@Stateless
public class DomicilioFacade extends AbstractFacade<Domicilio> {
    @PersistenceContext(unitName = "abaidProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DomicilioFacade() {
        super(Domicilio.class);
    }
    
}
