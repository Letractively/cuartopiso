/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorge
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    Usuario validarUsuario(String username, String password);
    
    Usuario buscarPorUsername(String username);
}
