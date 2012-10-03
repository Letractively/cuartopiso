/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Proveedores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorge
 */
@Stateless
public class ProveedoresFacade extends AbstractFacade<Proveedores> {
    @PersistenceContext(unitName = "CarroCompraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedoresFacade() {
        super(Proveedores.class);
    }
    
}
