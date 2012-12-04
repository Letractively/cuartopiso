package negocio;

import entidades.Cliente;
import entidades.Distrito;
import entidades.Domicilio;
import entidades.Profesion;
import entidades.Usuario;
import javax.ejb.Local;

@Local
public interface GestorUsuarioLocal {

    boolean validarUsuario(String login, String pass);

    boolean validarAlta();

//    void registrarCliente(String cuilCuit, String apellido, String nombre, String telefono, String celular, 
//            String email, Date fechaNacimiento, Double sueldo, String estadoCivil, String calle, short nro,
//            Distrito distrito, short piso, String dpto,
//            Profesion profesionId, Domicilio domicilioId);
    
    void registrarCliente(Cliente cliente);
    
    void editarCliente(Cliente datosCliente);
    
    Usuario actualizarPassword(Long idUsuario, String password);
    
    boolean existeUsuario(String login);
    
    void editarUsuario(Usuario datosUsuario);
    
    void crearProfesion(Profesion datosProfesion);
    
    Cliente buscarPorCuil(String cuil);
    
    void registrarDomicilio(Domicilio domicilio);    
    
    Profesion insertarProfesion(String profesion);
    
    Distrito insertarDistrito(String distrito);
    
    void eliminarCliente(Cliente idCliente);
    
    void eliminarDomicilio(Domicilio domicilio);        
      
    Cliente buscarCliente(Long idCliente);
    
    Domicilio buscarDomicilio(Long idDomicilio);
    
    String buscarAyN(String cuil);
}
