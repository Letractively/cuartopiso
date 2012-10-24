package negocio;

import dao.ClienteFacadeLocal;
import dao.ProfesionFacadeLocal;
import dao.UsuarioFacadeLocal;
import entidades.Cliente;
import entidades.Profesion;
import entidades.Usuario;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class GestorUsuario implements GestorUsuarioLocal {

    @EJB
    private ProfesionFacadeLocal profesionFacade;
    @EJB
    private ClienteFacadeLocal clienteFacade;
    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    @Override
    public boolean validarUsuario(String login, String pass) {
        Usuario usuario;
        boolean resultado = false;
        usuario = usuarioFacade.buscarPorLogin(login);
        if (usuario != null) {
            if (usuario.getPassword().equals(pass)) {
                resultado = true;
            }
        }
        return resultado;
    }

    @Override
    public boolean validarAlta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /* NUEVO CLIENTE: 
     SETEA DISTRITO A DOMICILIO Y CREA DOMICILIO
     SETEA DOMICILIO A CLIENTE
     SETEA PROFESION A CLIENTE
     CREA CLIENTE*/
    @Override
    public void registrarCliente(Cliente cliente) {        
        clienteFacade.create(cliente);
    }

    @Override
    public void editarCliente(Cliente datosCliente) {
        clienteFacade.edit(datosCliente);
    }

    @Override
    public Usuario actualizarPassword(Long idUsuario, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean existeUsuario(String login) {
        return (usuarioFacade.buscarPorLogin(login) != null);
    }

    @Override
    public void editarUsuario(Usuario datosUsuario) {
        usuarioFacade.edit(datosUsuario);
    }

    @Override
    public void crearProfesion(Profesion datosProfesion) {
        profesionFacade.create(datosProfesion);
    }

    @Override
    public Cliente buscarPorCuil(String cuil) {
        return clienteFacade.findByCuil(cuil);
    }
}
