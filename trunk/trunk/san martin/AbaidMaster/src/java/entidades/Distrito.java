package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "distrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distrito.findAll", query = "SELECT d FROM Distrito d"),
    @NamedQuery(name = "Distrito.findByIdDistrito", query = "SELECT d FROM Distrito d WHERE d.idDistrito = :idDistrito"),
    @NamedQuery(name = "Distrito.findByNombre", query = "SELECT d FROM Distrito d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Distrito.findByLocalidad", query = "SELECT d FROM Distrito d WHERE d.localidadId = :localidad")})
    public class Distrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDistrito")
    private Long idDistrito;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "localidad_id", referencedColumnName = "idLocalidad")
    @ManyToOne(fetch = FetchType.LAZY)
    private Localidad localidadId;

    public Distrito(Long idDistrito, String nombre) {
        this.idDistrito = idDistrito;
        this.nombre = nombre;
    }
    
    public Distrito() {
    }

    public Distrito(Long idDistrito) {
        this.idDistrito = idDistrito;
    }

    public Long getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Long idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Localidad getLocalidadId() {
        return localidadId;
    }

    public void setLocalidadId(Localidad localidadId) {
        this.localidadId = localidadId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDistrito != null ? idDistrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distrito)) {
            return false;
        }
        Distrito other = (Distrito) object;
        if ((this.idDistrito == null && other.idDistrito != null) || (this.idDistrito != null && !this.idDistrito.equals(other.idDistrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
}