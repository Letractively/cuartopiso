/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package frontera;

import entidades.Productos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aleatrix
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> {
    @PersistenceContext(unitName = "paginaOlivePU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }

}
