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
 * @author pablo
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "abaidProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario validarUsuario(String username, String password) {
        Usuario usuario;
        usuario = buscarPorLogin(username);
        if (usuario != null) {
            if (usuario.getPsw().equals(password)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario buscarPorLogin(String username) {
        Query q;
        q = em.createNamedQuery("Usuario.findByUsr");
        q.setParameter("usr", username);
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
