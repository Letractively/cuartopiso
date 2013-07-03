/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.UsuarioFacadeLocal;
import entidades.Usuario;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jorge
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class Login implements Serializable {

    private Usuario usuario;
    private String username;
    private String password;
    private boolean logged = true;
    private String mensaje;
    private Date fechaActual = new Date();
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    public void validarUsuario() {
        try {
            Usuario usuarioActual = usuarioFacade.validarUsuario(usuario.getUsername(), usuario.getPassword());
            if (usuarioActual != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("USUARIO", usuario);
                FacesContext.getCurrentInstance().getExternalContext().redirect("inicio.xhtml");
                logged = true;
                String fecha = formatoFecha.format(fechaActual);
                usuarioActual.setUltimoAcceso(fecha);
                usuarioFacade.edit(usuarioActual);
//                mostrar();
            } else {
                logged = false;
                mensaje = "Usuario y/o clave invalida";
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    e.getMessage(), ""));
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        logged = false;
//        mostrar();
        return "login";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Login() {
        usuario = new Usuario();
    }
}
