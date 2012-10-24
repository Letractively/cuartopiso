package dao;

import entidades.Distrito;
import entidades.Domicilio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DomicilioFacade extends AbstractFacade<Domicilio> implements DomicilioFacadeLocal {

@PersistenceContext(unitName = "AbaidMasterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DomicilioFacade() {
        super(Domicilio.class);
    }
    
}
