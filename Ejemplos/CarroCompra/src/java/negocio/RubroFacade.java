/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Rubro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorge
 */
@Stateless
public class RubroFacade extends AbstractFacade<Rubro> {
    @PersistenceContext(unitName = "CarroCompraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RubroFacade() {
        super(Rubro.class);
    }
    
}
