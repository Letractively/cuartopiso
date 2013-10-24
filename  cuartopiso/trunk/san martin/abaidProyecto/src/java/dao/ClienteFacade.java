/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cliente;
import entidades.Credito;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pablo
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {
    @PersistenceContext(unitName = "abaidProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
     public Cliente validarUsuario(int dni) {
        Cliente cliente;
        cliente = buscarPorDni(dni);
        if (cliente != null) {
            if (cliente.getDni().equals(dni)){
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscarPorDni(int dni) {
        Query q;
        q = em.createNamedQuery("Cliente.findByDni");
        q.setParameter("dni", dni);
        List<Cliente> resultados = q.getResultList();

        if (resultados == null) {
            return null;  // No encontrado
        } else if (resultados.size() != 1) {
            return null; // No encontrado
        } else {
            return resultados.get(0);  // Devuelve el encontrado
        }
    }
}
