/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jorge
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {
    @PersistenceContext(unitName = "NuevoAbaidPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    public List<String> listarDni() { 
        List<String> listaDNI = new ArrayList<String>();
        Query q = em.createQuery("SELECT c.cuilCuit FROM Cliente c WHERE c.cuilCuit != NULL");
        List<String> lista = q.getResultList();
        for (int i = 0; i < lista.size(); i++) {
            String dni = lista.get(i).substring(3, 10);
            listaDNI.add(dni);
        }        
        return listaDNI;
    }
    
}
