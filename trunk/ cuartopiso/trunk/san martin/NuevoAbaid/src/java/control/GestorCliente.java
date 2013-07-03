/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ClienteFacadeLocal;
import entidades.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Jorge
 */
@ManagedBean(name = "gestorCliente")
@RequestScoped
public class GestorCliente {
    @EJB
    private ClienteFacadeLocal clienteFacade;
    
    private Cliente cliente;
    private String dniSelec;

    public String getDniSelec() {
        return dniSelec;
    }

    public void setDniSelec(String dniSelec) {
        this.dniSelec = dniSelec;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public GestorCliente() {
        cliente = new Cliente();
    }
    
    public List<String> consultarCuil(){
        return clienteFacade.listarDni();
    }
}
