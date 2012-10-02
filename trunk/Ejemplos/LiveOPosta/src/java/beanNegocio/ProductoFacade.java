/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beanNegocio;

import entidades.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alumno
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {
    @PersistenceContext(unitName = "LiveOPostaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }

    public List<Producto> buscarPorRanking(int ranking) {
        Query q = em.createQuery("SELECT object(p) FROM Producto AS p "+
                                 "  WHERE (p.ranking LIKE :patron)");
        q.setParameter("patron", "%"+ ranking +"%");
        return q.getResultList();
    }
    
    public List<Producto> buscarPorRubro(String idRubro) {
        Query q = em.createQuery("SELECT object(p) FROM Producto AS p "+
                                 "  WHERE (p.rubro.id = :pat)");
        Long val = Long.parseLong(idRubro);
        q.setParameter("pat",  val );
        return q.getResultList();
    }
    
   
}
