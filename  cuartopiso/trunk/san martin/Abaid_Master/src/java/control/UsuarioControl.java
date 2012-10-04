package control;

import dao.ClienteFacadeLocal;
import entidades.Cliente;
import entidades.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "usuarioControl")
@SessionScoped
public class UsuarioControl {

    private Usuario usuario;
    private Cliente cliente;
    private ClienteFacadeLocal clienteFacadeLocal;

    public void crearCliente() {
        cliente = new Cliente();
        clienteFacadeLocal.create(cliente);
    }

    public ClienteFacadeLocal getClienteFacadeLocal() {
        return clienteFacadeLocal;
    }

    public void setClienteFacadeLocal(ClienteFacadeLocal clienteFacadeLocal) {
        this.clienteFacadeLocal = clienteFacadeLocal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioControl() {
        usuario = new Usuario();
        cliente = new Cliente();
    }

    public String validaUsuario() {
        if (usuario.getLogin().equals("admin") && (usuario.getPassword().equals("1234"))) {
            return "ok";
        } else {
            return "ok";
        }
    }

    public void validarAlta() {
    }
}
