/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import daos.ClientesDao;
import entidades.Cliente;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pablonello
 */
@ManagedBean
@SessionScoped
public class EjemploController {

    /**
     * Creates a new instance of EjemploController
     */
    public EjemploController() {
    }
    
    @EJB
    ClientesDao cd;
    
    Cliente clienteActual;
    List<Cliente> listaClientes;
    String cadenaBusqueda;

    public ClientesDao getCd() {
        return cd;
    }

    public void setCd(ClientesDao cd) {
        this.cd = cd;
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public void setClienteActual(Cliente clienteActual) {
        this.clienteActual = clienteActual;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public String getCadenaBusqueda() {
        return cadenaBusqueda;
    }

    public void setCadenaBusqueda(String cadenaBusqueda) {
        this.cadenaBusqueda = cadenaBusqueda;
    }
    
    // Inicializacion
//    @PostConstruct
//    public void inicializar() {
//        listaClientes = cd.buscarTodos();
//        clienteActual = listaClientes.get(0);
//    }
    
    public String doBuscarCliente() {
        listaClientes = cd.buscarPorNombre(cadenaBusqueda);
        clienteActual = listaClientes.get(0);
        return "index";
    }

    public String doNuevoCliente() {
        clienteActual = new Cliente();
        return "nuevoCliente";
    }

    public String doGuardarCliente() {
        cd.crear(clienteActual);
        return "index";
    }
}
