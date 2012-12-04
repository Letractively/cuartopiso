
package dao;

import entidades.Localidad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LocalidadFacade extends AbstractFacade<Localidad> implements LocalidadFacadeLocal {
    @PersistenceContext(unitName = "AbaidMasterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalidadFacade() {
        super(Localidad.class);
    }

    @Override
    public Localidad getLocalidad(String localidad) {
        Query q = em.createNamedQuery("Localidad.findByNombre");
        q.setParameter("nombre", localidad);
        List<Localidad> resultados = q.getResultList();
        if (resultados == null) {
            return null;
        } else if (resultados.size() != 1) {
            return null;
        } else {
            return resultados.get(0);
        }
    }    
}
