package negocio;

import dao.ClienteFacadeLocal;
import dao.DistritoFacadeLocal;
import dao.DomicilioFacadeLocal;
import dao.ProfesionFacadeLocal;
import dao.UsuarioFacadeLocal;
import entidades.Cliente;
import entidades.Distrito;
import entidades.Domicilio;
import entidades.Profesion;
import entidades.Usuario;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class GestorUsuario implements GestorUsuarioLocal {
    @EJB
    private DistritoFacadeLocal distritoFacade;
    @EJB
    private DomicilioFacadeLocal domicilioFacade;
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

//    @Override
//    public void registrarDomicilio(String calle, short nro,Distrito distrito, short piso, String dpto){
//        Domicilio domicilio = new Domicilio();               
//        domicilio.setCalle(calle);
//        domicilio.setDpto(dpto);
//        domicilio.setNumero(nro);
//        domicilio.setPiso(piso);
//        domicilio.setDistritoId(distrito);
//    }
    /* NUEVO CLIENTE: 
     SETEA DISTRITO A DOMICILIO Y CREA DOMICILIO
     SETEA DOMICILIO A CLIENTE
     SETEA PROFESION A CLIENTE
     CREA CLIENTE*/
//    public void registrarCliente(String cuil, String apellido, String nombre, String telefono, String celular,
//            String email, Date fechaNace, Double sueldo, String estadoCivil,
//            Profesion profesionId, Domicilio domicilioId) {
//        Cliente cliente = new Cliente();
//        cliente.setApellido(apellido);
//        cliente.setNombre(nombre);
//        cliente.setCuilCuit(cuil);
//        cliente.setEmail(email);
//        cliente.setEstadoCivil(estadoCivil);
//        cliente.setFechaNacimiento(fechaNace);
//        cliente.setSueldo(sueldo);
//        
//        
//        
////        cliente.agregaDomicilio(domicilio);
////        cliente.setDomicilioId(domicilio);
//        cliente.setProfesionId(profesionId);
//        clienteFacade.create(cliente);
//    }

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

    @Override
    public void registrarCliente(Cliente cliente) {
        clienteFacade.create(cliente);
    }

    @Override
    public void registrarDomicilio(Domicilio domicilio) {
        domicilioFacade.create(domicilio);
    }    

    @Override
    public Profesion insertarProfesion(String profesion) {
        return profesionFacade.findByNombre(profesion);
    }

    @Override
    public Distrito insertarDistrito(String distrito) {
        return distritoFacade.findByNombre(distrito);
//        return distritoFacade.find(distrito);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteFacade.remove(cliente);
    }

    @Override
    public Domicilio buscarDomicilio(Long idDomicilio){
        return domicilioFacade.find(idDomicilio);
    }
    
    @Override
    public void eliminarDomicilio(Domicilio domicilio) {
        domicilioFacade.remove(domicilio);
    }

    @Override
    public Cliente buscarCliente(Long idCliente) {
        return clienteFacade.find(idCliente);
    }

    @Override
    public String buscarAyN(String cuil) {
        return clienteFacade.findLastFirst(cuil);
    }
}
