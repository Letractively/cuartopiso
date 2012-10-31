/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import entidades.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author pablonello
 */
@Stateless
@LocalBean
public class ClientesDao {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    EntityManager em;

    public void crear(Cliente cliente) {
        em.persist(cliente);
    }

    public void actualizar(Cliente cliente) {
        em.merge(cliente);
    }

    public void borrar(Cliente cliente) {
        em.remove(cliente);
    }

    public Cliente buscarPorID(Long id) {
        return (em.find(Cliente.class, id));
    }

    public List<Cliente> buscarTodos() {
        Query q = em.createQuery("SELECT c FROM cliente c");
        return q.getResultList();
    }

    public List<Cliente> buscarPorNombre(String nombre) {
        Query q = em.createQuery("SELECT c FROM cliente c WHERE c.cliente.nombre ₧ :nombre");
        q.setParameter("nombre", nombre);
        return q.getResultList();
    }

    public List<Cliente> buscarPorCliente(Integer idCliente) {
        Query q = em.createQuery("SELECT p FROM cliente p WHERE p.cliente.idcliente = :idCliente");
        q.setParameter("idCliente", idCliente);
        return q.getResultList();
}
}
