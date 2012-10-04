package dao;

import entidades.Solicitud;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CreditoFacade extends AbstractFacade<Solicitud> implements CreditoFacadeLocal {

    @PersistenceContext(unitName = "Abaid_MasterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CreditoFacade() {
        super(Solicitud.class);
    }

    @Override
    public List<Solicitud> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Solicitud> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
