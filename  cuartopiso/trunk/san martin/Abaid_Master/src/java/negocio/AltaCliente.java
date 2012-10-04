package negocio;

import dao.ClienteFacade;
import dao.ClienteFacadeLocal;
import entidades.Cliente;
import entidades.Domicilio;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.FlowEvent;

@ManagedBean(name = "altaCliente")
@ViewScoped
public class AltaCliente {

    private Cliente cliente = new Cliente();
    
    private ClienteFacadeLocal clienteFacadeLocal;
    private boolean skip;
//    private static final Logger logger = Logger.getLogger(AltaCliente.class.getName());

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void save() {

        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + cliente.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
//        logger.info("Current wizard step:" + event.getOldStep());  
//        logger.info("Next step:" + event.getNewStep());  

        if (event.getOldStep().equalsIgnoreCase("personal")) {

            return event.getOldStep();

        }
        if (skip) {
            skip = false;   //reset in case cliente goes back  
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }
}
