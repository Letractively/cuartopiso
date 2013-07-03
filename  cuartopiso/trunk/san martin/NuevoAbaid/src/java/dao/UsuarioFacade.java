/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jorge
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "NuevoAbaidPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario validarUsuario(String username, String password) {
        Usuario usuario;
        usuario = buscarPorUsername(username);
        if (usuario != null) {
            if (usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }
    
    @Override
    public Usuario buscarPorUsername(String username) {
        Query q = em.createNamedQuery("Usuario.findByUsername");
        q.setParameter("username", username);
        List<Usuario> resultados = q.getResultList();

        if (resultados == null) {
            return null;  // No encontrado
        } else if (resultados.size() != 1) {
            return null; // No encontrado
        } else {
            return resultados.get(0);  // Devuelve el encontrado
        }
    }
}
