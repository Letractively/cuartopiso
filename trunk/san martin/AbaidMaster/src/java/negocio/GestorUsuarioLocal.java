package negocio;

import entidades.Cliente;
import entidades.Profesion;
import entidades.Usuario;
import javax.ejb.Local;

@Local
public interface GestorUsuarioLocal {

    boolean validarUsuario(String login, String pass);

    boolean validarAlta();

    void registrarCliente(Cliente cliente);
    
    void editarCliente(Cliente datosCliente);
    
    Usuario actualizarPassword(Long idUsuario, String password);
    
    boolean existeUsuario(String login);
    
    void editarUsuario(Usuario datosUsuario);
    
    void crearProfesion(Profesion datosProfesion);
    
    Cliente buscarPorCuil(String cuil);
        
}
