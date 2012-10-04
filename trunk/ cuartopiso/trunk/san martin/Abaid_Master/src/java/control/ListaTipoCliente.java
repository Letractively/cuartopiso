
package control;

import entidades.TipoCliente;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class ListaTipoCliente {

    public TipoCliente[] getTipoClientes(){
        return TipoCliente.values();
    }    
}
