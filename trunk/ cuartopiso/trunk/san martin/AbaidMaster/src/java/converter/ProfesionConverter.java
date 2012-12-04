
package converter;

import entidades.Profesion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean(name = "profesionConverter")
@SessionScoped
public class ProfesionConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
	    String toObject[] = value.split(":");
	    Profesion profesion = new Profesion();
	    profesion.setIdProfesion(Long.parseLong(toObject[0]));
	    profesion.setNombre(toObject[1]);	    
	    return profesion;
	}
	return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Profesion) {
	    Profesion profesion = (Profesion) value;
	    String profesionId = Long.toString(profesion.getIdProfesion());
	    String nombre = profesion.getNombre();	    
	    String toString = profesionId + ":" + nombre;
	    return toString;
	} else {
	    //return "No se pudo parsear el objeto.";
	    return "-1";
	}
    }
    
}
