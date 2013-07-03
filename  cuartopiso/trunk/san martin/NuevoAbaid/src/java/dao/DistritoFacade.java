/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Distrito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorge
 */
@Stateless
public class DistritoFacade extends AbstractFacade<Distrito> implements DistritoFacadeLocal {
    @PersistenceContext(unitName = "NuevoAbaidPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DistritoFacade() {
        super(Distrito.class);
    }
    
}
