package negocio;

import dao.ClienteFacadeLocal;
import dao.DistritoFacadeLocal;
import dao.LocalidadFacadeLocal;
import dao.ProfesionFacadeLocal;
import entidades.Cliente;
import entidades.Distrito;
import entidades.Localidad;
import entidades.Profesion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class GestorListas implements GestorListasLocal {
    @EJB
    private ClienteFacadeLocal clienteFacade;
    @EJB
    private DistritoFacadeLocal distritoFacade;
    @EJB
    private LocalidadFacadeLocal localidadFacade;
    @EJB
    private ProfesionFacadeLocal profesionFacade;

    @Override
    public List<Profesion> profesiones() {
//        return profesionFacade.buscarProfesiones();
        return profesionFacade.findAll();
    }

    @Override
    public List<Localidad> localidades() {        
        return localidadFacade.findAll();
    }
    
    @Override
    public List<Distrito> distritos(){
        return distritoFacade.findAll();
    }

    @Override
    public List<Distrito> buscarDistritos(Localidad localidad) {
        return distritoFacade.findByLocalidad(localidad);
    }
        
    @Override
    public List<Cliente> clientes() {
//        return clienteFacade.clientes();
        return clienteFacade.findAll();
    }
    
    @Override
    public Localidad getLocalidad(String localidad){
        return localidadFacade.getLocalidad(localidad);
    }
}
