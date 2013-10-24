/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cliente;
import entidades.Plan;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pablo
 */
@Stateless
public class PlanFacade extends AbstractFacade<Plan> {
    @PersistenceContext(unitName = "abaidProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanFacade() {
        super(Plan.class);
    }

    public List<Plan> buscarDistritos(Cliente cliente) {
         Query q = em.createNamedQuery("SELECT d FROM plan d WHERE d.idCredito = :idCredito");
        q.setParameter("cliente", cliente);
        return q.getResultList();
    }
    
    
}
