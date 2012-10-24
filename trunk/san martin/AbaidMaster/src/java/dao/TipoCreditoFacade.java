package dao;

import entidades.TipoCredito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TipoCreditoFacade extends AbstractFacade<TipoCredito> implements TipoCreditoFacadeLocal {

@PersistenceContext(unitName = "AbaidMasterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoCreditoFacade() {
        super(TipoCredito.class);
    }
}
