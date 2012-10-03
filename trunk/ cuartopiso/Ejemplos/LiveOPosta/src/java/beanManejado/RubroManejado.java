/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanManejado;

import beanNegocio.RubrosFacade;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.IntArrayData;
import entidades.Rubro;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author KaNawogirusa
 */
@ManagedBean(name = "RubroManejado")
@RequestScoped
public class RubroManejado {
    @EJB
    private RubrosFacade rubrosFacade;
    private Rubro rubro;
    
    private List<Rubro>rubros;
    /** Creates a new instance of RubroManejado */
    public RubroManejado() {
        rubro = new Rubro();
        rubros = new ArrayList<Rubro>();
        
    }
    

     public List<SelectItem> getRubrosList() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        rubros = rubrosFacade.findAll();
        for (Rubro rubro : rubros) {
                SelectItem item;
                item = new SelectItem(rubro.getId(), rubro.getDescripcion(), "", false, false);
                
                list.add(item);                 
        }
        return list;
}

  
     
    
    
    
    public List<Rubro> buscarTodosLosRubros() {
        rubros = rubrosFacade.findAll();
        return rubros;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public List<Rubro> getRubros() {
        return rubros;
    }

    public void setRubros(List<Rubro> rubros) {
        this.rubros = rubros;
    }

    public RubrosFacade getRubrosFacade() {
        return rubrosFacade;
    }

    public void setRubrosFacade(RubrosFacade rubrosFacade) {
        this.rubrosFacade = rubrosFacade;
    }
    
   
    
}
