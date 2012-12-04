package dao;

import entidades.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "AbaidMasterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    // RETORNA EL CLIENTE SELECCIONADO EN LA TABLA
    @Override
    public Cliente rowSelCliente(Long id) {
        Query q = em.createQuery("SELECT object(c) FROM Cliente AS c "
                + "  WHERE (c.idCliente LIKE :param)");
        q.setParameter("idCliente", "%" + id + "%");
        return (Cliente) q.getSingleResult();
    }

    @Override
    public Cliente findByCuil(String cuil) {
        Query q = em.createNamedQuery("Cliente.findByCuilCuit");
        q.setParameter("cuilCuit", cuil);
        List<Cliente> resultados = q.getResultList();
        if (resultados == null) {
            return null;  // No encontrado
        } else if (resultados.size() != 1) {
            return null; // No encontrado o duplicado
        } else {
            return resultados.get(0);  // Devuelve el encontrado
        }
    }

    @Override
    public List<Cliente> findByApellido(String apellido) {
        Query q = em.createNamedQuery("Cliente.findByApellido");
        q.setParameter("apellido", apellido);
        return q.getResultList();
    }

    @Override
    public List<Cliente> listaClientes() {
        Query q = em.createNamedQuery("Cliente.findAll");
        return q.getResultList();
    }

    @Override
    public List<String> findCuil() {
        Query q = em.createQuery("SELECT c.cuilCuit FROM Cliente AS c WHERE c.cuilCuit IS NOT NULL "
                + "AND LENGTH(c.cuilCuit) > 0 ORDER BY c.cuilCuit");
        return q.getResultList();
    }

    @Override
    public String findLastFirst(String cuil) {
        Query q = em.createQuery("SELECT c.apellido, c.nombre FROM Cliente c WHERE c.cuilCuit LIKE :cuil");
        q.setParameter("cuil", cuil);
        Object[] resultado = (Object[]) q.getSingleResult();
        String apellido = (String) resultado[0];
        String nombre = (String) resultado[1];
        if (resultado == null) {
            return null;  // No encontrado
        } else {
            return apellido + ", " + nombre; // Devuelve el encontrado
        }
    }
}
