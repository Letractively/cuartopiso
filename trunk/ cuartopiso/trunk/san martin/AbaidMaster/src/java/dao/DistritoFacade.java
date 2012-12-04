package dao;

import entidades.Distrito;
import entidades.Localidad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class DistritoFacade extends AbstractFacade<Distrito> implements DistritoFacadeLocal {

    @PersistenceContext(unitName = "AbaidMasterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DistritoFacade() {
        super(Distrito.class);
    }

    @Override
    public List<Distrito> findByLocalidad(Localidad localidad) {
        Query q = em.createNamedQuery("Distrito.findByLocalidad");
        q.setParameter("localidad", localidad);
        return q.getResultList();
    }

    @Override
    public Distrito findByNombre(String nombre) {
        Query q = em.createNamedQuery("Distrito.findByNombre");
        q.setParameter("nombre", nombre);
        List<Distrito> resultados = q.getResultList();
        if (resultados == null) {
            return null;  // No encontrado
        } else if (resultados.size() != 1) {
            return null; // No encontrado
        } else {
            return resultados.get(0);  // Devuelve el encontrado
        }
    }
}
