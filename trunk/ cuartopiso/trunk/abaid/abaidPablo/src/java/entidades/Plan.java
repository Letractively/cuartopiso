/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "plan", catalog = "abaidposta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plan.findAll", query = "SELECT p FROM Plan p"),
    @NamedQuery(name = "Plan.findByIdPlan", query = "SELECT p FROM Plan p WHERE p.idPlan = :idPlan"),
    @NamedQuery(name = "Plan.findByCanCuotas", query = "SELECT p FROM Plan p WHERE p.canCuotas = :canCuotas"),
    @NamedQuery(name = "Plan.findByCodigo", query = "SELECT p FROM Plan p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Plan.findByDiasDeGacias", query = "SELECT p FROM Plan p WHERE p.diasDeGacias = :diasDeGacias"),
    @NamedQuery(name = "Plan.findByVencimiento", query = "SELECT p FROM Plan p WHERE p.vencimiento = :vencimiento"),
    @NamedQuery(name = "Plan.findByDescripcion", query = "SELECT p FROM Plan p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Plan.findByEstado", query = "SELECT p FROM Plan p WHERE p.estado = :estado"),
    @NamedQuery(name = "Plan.findByLimiteCapital", query = "SELECT p FROM Plan p WHERE p.limiteCapital = :limiteCapital")})
public class Plan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlan")
    private Integer idPlan;
    @Column(name = "canCuotas")
    private Integer canCuotas;
    @Size(max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "diasDeGacias")
    private Integer diasDeGacias;
    @Column(name = "vencimiento")
    private Integer vencimiento;
    @Column(name = "descripcion")
    private Integer descripcion;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @Column(name = "limiteCapital")
    private Integer limiteCapital;
    @JoinColumn(name = "idInteres", referencedColumnName = "idInteres")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Interes idInteres;

    public Plan() {
    }

    public Plan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Integer getCanCuotas() {
        return canCuotas;
    }

    public void setCanCuotas(Integer canCuotas) {
        this.canCuotas = canCuotas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getDiasDeGacias() {
        return diasDeGacias;
    }

    public void setDiasDeGacias(Integer diasDeGacias) {
        this.diasDeGacias = diasDeGacias;
    }

    public Integer getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Integer vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Integer getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Integer descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getLimiteCapital() {
        return limiteCapital;
    }

    public void setLimiteCapital(Integer limiteCapital) {
        this.limiteCapital = limiteCapital;
    }

    public Interes getIdInteres() {
        return idInteres;
    }

    public void setIdInteres(Interes idInteres) {
        this.idInteres = idInteres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlan != null ? idPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plan)) {
            return false;
        }
        Plan other = (Plan) object;
        if ((this.idPlan == null && other.idPlan != null) || (this.idPlan != null && !this.idPlan.equals(other.idPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Plan[ idPlan=" + idPlan + " ]";
    }
    
}
