package dao;

import entidades.TipoCliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TipoClienteFacade extends AbstractFacade<TipoCliente> implements TipoClienteFacadeLocal {

    @PersistenceContext(unitName = "AbaidMasterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoClienteFacade() {
        super(TipoCliente.class);
    }
}
