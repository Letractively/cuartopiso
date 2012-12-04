
package converter;

import entidades.Distrito;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean(name = "distritoConverter")
@SessionScoped
public class DistritoConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
	    String toObject[] = value.split(":");
	    Distrito distrito = new Distrito();
	    distrito.setIdDistrito(Long.parseLong(toObject[0]));
	    distrito.setNombre(toObject[1]);	    
	    return distrito;
	}
	return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Distrito) {
	    Distrito distrito = (Distrito) value;
	    String distritoId = Long.toString(distrito.getIdDistrito());
	    String nombre = distrito.getNombre();	    
	    String toString = distritoId + ":" + nombre;
	    return toString;
	} else {
	    //return "No se pudo parsear el objeto.";
	    return "-1";
	}
    }    
}
