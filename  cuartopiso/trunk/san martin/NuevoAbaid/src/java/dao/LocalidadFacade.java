/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Localidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorge
 */
@Stateless
public class LocalidadFacade extends AbstractFacade<Localidad> implements LocalidadFacadeLocal {
    @PersistenceContext(unitName = "NuevoAbaidPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalidadFacade() {
        super(Localidad.class);
    }
    
}
