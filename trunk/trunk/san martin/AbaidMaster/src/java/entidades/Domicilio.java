
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

@Entity
@Table(name = "domicilio")
@NamedQueries({
    @NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d"),
    @NamedQuery(name = "Domicilio.findByIdDomicilio", query = "SELECT d FROM Domicilio d WHERE d.idDomicilio = :idDomicilio"),
    @NamedQuery(name = "Domicilio.findByCalle", query = "SELECT d FROM Domicilio d WHERE d.calle = :calle"),
    @NamedQuery(name = "Domicilio.findByNumero", query = "SELECT d FROM Domicilio d WHERE d.numero = :numero"),
    @NamedQuery(name = "Domicilio.findByPiso", query = "SELECT d FROM Domicilio d WHERE d.piso = :piso"),
    @NamedQuery(name = "Domicilio.findByDpto", query = "SELECT d FROM Domicilio d WHERE d.dpto = :dpto")})
public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDomicilio")
    private Long idDomicilio;
    @Size(max = 20)
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private Short numero;
    @Column(name = "piso")
    private Short piso;
    @Size(max = 10)
    @Column(name = "dpto")
    private String dpto;    
    @Size(max = 255)
    @Column(name = "observacion")
    private String observacion;    
    @JoinColumn(name = "distrito_id", referencedColumnName = "idDistrito")
    @ManyToOne(fetch = FetchType.LAZY)
    private Distrito distritoId;

    public Domicilio() {
    }
    
    public Domicilio(Long idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Domicilio(String calle, Short numero, Short piso, String dpto, String observacion, Distrito distritoId) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.dpto = dpto;
        this.observacion = observacion;
        this.distritoId = distritoId;
    }

    public Long getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Long idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Short getNumero() {
        return numero;
    }

    public void setNumero(Short numero) {
        this.numero = numero;
    }

    public Short getPiso() {
        return piso;
    }

    public void setPiso(Short piso) {
        this.piso = piso;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }    

    public Distrito getDistritoId() {
        return distritoId;
    }

    public void setDistritoId(Distrito distritoId) {
        this.distritoId = distritoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDomicilio != null ? idDomicilio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domicilio)) {
            return false;
        }
        Domicilio other = (Domicilio) object;
        if ((this.idDomicilio == null && other.idDomicilio != null) || (this.idDomicilio != null && !this.idDomicilio.equals(other.idDomicilio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Domicilio[ idDomicilio=" + idDomicilio + " ]";
    }    
}
