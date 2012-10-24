package control;

import entidades.Cliente;
import entidades.Distrito;
import entidades.EstadoCivil;
import entidades.Localidad;
import entidades.Profesion;
import entidades.TipoCliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import negocio.GestorListasLocal;

@ManagedBean(name = "listasControl")
@ViewScoped
public class ListasControl implements Serializable{

    private String localidadSelec;
    private String distritoSelec;
    private Localidad localidad;
    private Distrito distrito;
    private Profesion profesion;
    private Cliente cliente;
    private List<Cliente> clientes;
    private List<Profesion> profesiones;
    private List<Distrito> distritos;
    private List<Localidad> localidades;
    @EJB
    private GestorListasLocal gestorListas;

    public List<Localidad> getLocalidades() {
        return gestorListas.localidades();
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public List<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(List<Distrito> distritos) {
        this.distritos = distritos;
    }

    public String getLocalidadSelec() {
        return localidadSelec;
    }

    public void setLocalidadSelec(String localidadSelec) {
        this.localidadSelec = localidadSelec;
    }

    public String getDistritoSelec() {
        return distritoSelec;
    }

    public void setDistritoSelec(String distritoSelec) {
        this.distritoSelec = distritoSelec;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        if (clientes == null) {
            clientes = gestorListas.clientes();
        }
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ListasControl() {
        profesion = new Profesion();
        cliente = new Cliente();
        distritos = new ArrayList<Distrito>();
        localidades = new ArrayList<Localidad>();
        localidad = new Localidad();
        distrito = new Distrito();
    }

    public List<Profesion> getProfesiones() {
        if (profesiones == null) {
            profesiones = gestorListas.profesiones();
        }
        return profesiones;
    }

    public void setProfesiones(List<Profesion> profesiones) {
        this.profesiones = profesiones;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public void distritosPorLocalidad() {
        
        if (localidadSelec != null && !localidadSelec.equals("")) {
            Localidad loca = gestorListas.getLocalidad(localidadSelec);
            distritos = gestorListas.buscarDistritos(loca);
        } else {
            distritos = new ArrayList<Distrito>();
        }
    }

    public TipoCliente[] getTipoClientes() {
        return TipoCliente.values();
    }
    
    public EstadoCivil[] getEstadoCivil() {
        return EstadoCivil.values();
    }
}
