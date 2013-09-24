/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Almafuerte
 */
@Entity
@Table(name = "interes", catalog = "abaidposta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interes.findAll", query = "SELECT i FROM Interes i"),
    @NamedQuery(name = "Interes.findByIdInteres", query = "SELECT i FROM Interes i WHERE i.idInteres = :idInteres"),
    @NamedQuery(name = "Interes.findByGastosAdmin", query = "SELECT i FROM Interes i WHERE i.gastosAdmin = :gastosAdmin"),
    @NamedQuery(name = "Interes.findByTasa", query = "SELECT i FROM Interes i WHERE i.tasa = :tasa"),
    @NamedQuery(name = "Interes.findBySellado", query = "SELECT i FROM Interes i WHERE i.sellado = :sellado"),
    @NamedQuery(name = "Interes.findByRecargoXRefinanciacion", query = "SELECT i FROM Interes i WHERE i.recargoXRefinanciacion = :recargoXRefinanciacion"),
    @NamedQuery(name = "Interes.findByIntXMora", query = "SELECT i FROM Interes i WHERE i.intXMora = :intXMora"),
    @NamedQuery(name = "Interes.findByEstado", query = "SELECT i FROM Interes i WHERE i.estado = :estado"),
    @NamedQuery(name = "Interes.findByFecha", query = "SELECT i FROM Interes i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "Interes.findByObservacion", query = "SELECT i FROM Interes i WHERE i.observacion = :observacion")})
public class Interes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInteres")
    private Integer idInteres;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gastosAdmin")
    private Float gastosAdmin;
    @Column(name = "tasa")
    private Float tasa;
    @Column(name = "sellado")
    private Float sellado;
    @Column(name = "recargoXRefinanciacion")
    private Float recargoXRefinanciacion;
    @Column(name = "intXMora")
    private Float intXMora;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @Size(max = 10)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 50)
    @Column(name = "observacion")
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInteres", fetch = FetchType.LAZY)
    private List<Plan> planList;

    public Interes() {
    }

    public Interes(Integer idInteres) {
        this.idInteres = idInteres;
    }

    public Integer getIdInteres() {
        return idInteres;
    }

    public void setIdInteres(Integer idInteres) {
        this.idInteres = idInteres;
    }

    public Float getGastosAdmin() {
        return gastosAdmin;
    }

    public void setGastosAdmin(Float gastosAdmin) {
        this.gastosAdmin = gastosAdmin;
    }

    public Float getTasa() {
        return tasa;
    }

    public void setTasa(Float tasa) {
        this.tasa = tasa;
    }

    public Float getSellado() {
        return sellado;
    }

    public void setSellado(Float sellado) {
        this.sellado = sellado;
    }

    public Float getRecargoXRefinanciacion() {
        return recargoXRefinanciacion;
    }

    public void setRecargoXRefinanciacion(Float recargoXRefinanciacion) {
        this.recargoXRefinanciacion = recargoXRefinanciacion;
    }

    public Float getIntXMora() {
        return intXMora;
    }

    public void setIntXMora(Float intXMora) {
        this.intXMora = intXMora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public List<Plan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInteres != null ? idInteres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interes)) {
            return false;
        }
        Interes other = (Interes) object;
        if ((this.idInteres == null && other.idInteres != null) || (this.idInteres != null && !this.idInteres.equals(other.idInteres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Interes[ idInteres=" + idInteres + " ]";
    }
    
}
