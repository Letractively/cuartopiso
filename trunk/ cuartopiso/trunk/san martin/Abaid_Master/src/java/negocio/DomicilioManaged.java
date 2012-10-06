package negocio;

import entidades.Distrito;
import entidades.Localidad;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean(name = "domicilioManaged")
@SessionScoped
public class DomicilioManaged {

    @PersistenceContext(unitName = "Abaid_MasterPU")
    protected EntityManager em;
    private List<Distrito> distritos;
    private List<Distrito> listaDistritos;
    private List<Localidad> listaLocalidades;
    private Distrito distrito;
    private Localidad localidad;

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public List<Distrito> getListaDistritos() {
        return listaDistritos;
    }

    public void setListaDistritos(List<Distrito> listaDistritos) {
        this.listaDistritos = listaDistritos;
    }

    public List<Localidad> getListaLocalidades() {
        return listaLocalidades;
    }

    public void setListaLocalidades(List<Localidad> listaLocalidades) {
        this.listaLocalidades = listaLocalidades;
    }

    public DomicilioManaged() {
        listaDistritos = new ArrayList<Distrito>();
        listaLocalidades = new ArrayList<Localidad>();
        distrito = new Distrito();
        localidad = new Localidad();
    }

    // TRAE DISTRITOS SEGUN LA LOCALIDAD SELECCIONADA EN altaDomicilio
    public void getDistritos() {
//        if(localidad != null && !localidad.toString().equals("")) {
//            distritos = listaDistritos.
//        }
//        Query q = em.createQuery("SELECT object(l) FROM Localidad AS l WHERE l.idLocalidad = :idLocalidad");
//        q.setParameter("idLocalidad", idLocalidad);
//        return q.getResultList();
    }
    
    public String prueba(){
        return "altaDomicilio.xhtml";
    }
}
