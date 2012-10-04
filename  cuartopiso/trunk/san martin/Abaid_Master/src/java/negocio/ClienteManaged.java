package negocio;

import dao.ClienteFacadeLocal;
import entidades.Cliente;
import entidades.Profesion;
import entidades.TipoCliente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@ManagedBean(name = "clienteManaged")
@RequestScoped
public class ClienteManaged {

    @PersistenceContext(unitName = "Abaid_MasterPU")
    protected EntityManager em;
    @EJB
    private ClienteFacadeLocal clienteFacade;
    private List<Cliente> clientes;
    private Cliente cliente;
    private List<Profesion> profesiones;
    private Profesion profesion;
    private TipoCliente tipoCliente;

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }    

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }    
    
    public List<Profesion> getProfesiones() {
        Query q = em.createQuery("SELECT object(p) FROM Profesion AS p");
        return q.getResultList();
        
    }

    public void setProfesiones(List<Profesion> profesiones) {
        this.profesiones = profesiones;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteManaged() {
        clientes = new ArrayList<Cliente>();
        cliente = new Cliente();
    }

    public List<Cliente> getClientes() {
        Query q = em.createQuery("SELECT object(c) FROM Cliente AS c");
        return q.getResultList();
    }

    public String cargarCliente() {
        return "clientes";
    }

    public String volver() {
        return "volver";
    }
    
    public String wizard(){
        return "wizard";
    }
}
