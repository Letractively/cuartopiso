package dao;

import entidades.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "Abaid_MasterPU")
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
    public List<Cliente> listaClientes() {
        Query q = em.createQuery("SELECT idCliente, apellido, nombre FROM Cliente AS c");
        return q.getResultList();
    }
}
