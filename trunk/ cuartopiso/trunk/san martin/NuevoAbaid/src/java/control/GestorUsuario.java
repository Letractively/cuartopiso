/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.UsuarioFacadeLocal;
import entidades.Usuario;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jorge
 */
@ManagedBean(name = "gestorUsuario")
@SessionScoped
public class GestorUsuario {

    private Usuario usuario;
    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public GestorUsuario() {
        usuario = new Usuario();
    }

    public String registrarUsuario() {
        String url = "";
        Usuario nuevoUsuario = usuarioFacade.buscarPorUsername(usuario.getUsername());
        if (nuevoUsuario == null) {
            usuarioFacade.create(usuario);
            url = "login.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El nombre de usuario está en uso.", "regUser:username");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return url;
    }
}
