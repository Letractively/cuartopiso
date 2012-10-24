package dao;

import entidades.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            return null; // No encontrado
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
        Query q = em.createQuery("SELECT idCliente, apellido, nombre FROM Cliente AS c");
        return q.getResultList();
    }
   
    
}
