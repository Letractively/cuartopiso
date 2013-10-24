/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "credito", catalog = "abaidposta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credito.findAll", query = "SELECT c FROM Credito c"),
    @NamedQuery(name = "Credito.findByIdCredito", query = "SELECT c FROM Credito c WHERE c.idCredito = :idCredito"),
    @NamedQuery(name = "Credito.findByComprobante", query = "SELECT c FROM Credito c WHERE c.comprobante = :comprobante"),
    @NamedQuery(name = "Credito.findByCapital", query = "SELECT c FROM Credito c WHERE c.capital = :capital"),
    @NamedQuery(name = "Credito.findByCuota", query = "SELECT c FROM Credito c WHERE c.cuota = :cuota"),
    @NamedQuery(name = "Credito.findByMontoTotal", query = "SELECT c FROM Credito c WHERE c.montoTotal = :montoTotal"),
    @NamedQuery(name = "Credito.findByMontoXcuota", query = "SELECT c FROM Credito c WHERE c.montoXcuota = :montoXcuota"),
    @NamedQuery(name = "Credito.findByIntXcuota", query = "SELECT c FROM Credito c WHERE c.intXcuota = :intXcuota"),
    @NamedQuery(name = "Credito.findByFechaCredito", query = "SELECT c FROM Credito c WHERE c.fechaCredito = :fechaCredito"),
    @NamedQuery(name = "Credito.findByFechaVto1", query = "SELECT c FROM Credito c WHERE c.fechaVto1 = :fechaVto1"),
    @NamedQuery(name = "Credito.findByFechaVto2", query = "SELECT c FROM Credito c WHERE c.fechaVto2 = :fechaVto2"),
    @NamedQuery(name = "Credito.findByFechaCobro", query = "SELECT c FROM Credito c WHERE c.fechaCobro = :fechaCobro"),
    @NamedQuery(name = "Credito.findByMontoPagado", query = "SELECT c FROM Credito c WHERE c.montoPagado = :montoPagado"),
    @NamedQuery(name = "Credito.findByCancelado", query = "SELECT c FROM Credito c WHERE c.cancelado = :cancelado"),
    @NamedQuery(name = "Credito.findByDebe", query = "SELECT c FROM Credito c WHERE c.debe = :debe"),
    @NamedQuery(name = "Credito.findByIntXmora", query = "SELECT c FROM Credito c WHERE c.intXmora = :intXmora")})
public class Credito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCredito")
    private Integer idCredito;
    @Column(name = "comprobante")
    private Integer comprobante;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "capital")
    private Float capital;
    @Column(name = "cuota")
    private Integer cuota;
    @Column(name = "montoTotal")
    private Float montoTotal;
    @Column(name = "montoXcuota")
    private Float montoXcuota;
    @Column(name = "intXcuota")
    private Float intXcuota;
    @Column(name = "fechaCredito")
    @Temporal(TemporalType.DATE)
    private Date fechaCredito;
    @Column(name = "fechaVto1")
    @Temporal(TemporalType.DATE)
    private Date fechaVto1;
    @Column(name = "fechaVto2")
    @Temporal(TemporalType.DATE)
    private Date fechaVto2;
    @Column(name = "fechaCobro")
    @Temporal(TemporalType.DATE)
    private Date fechaCobro;
    @Column(name = "montoPagado")
    private Float montoPagado;
    @Size(max = 10)
    @Column(name = "cancelado")
    private String cancelado;
    @Column(name = "debe")
    private Float debe;
    @Column(name = "intXmora")
    private Float intXmora;
    @OneToMany(mappedBy = "idCredito", fetch = FetchType.LAZY)
    private List<Plan> planList;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente idCliente;

    public Credito() {
    }

    public Credito(Integer idCredito) {
        this.idCredito = idCredito;
    }

    public Integer getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(Integer idCredito) {
        this.idCredito = idCredito;
    }

    public Integer getComprobante() {
        return comprobante;
    }

    public void setComprobante(Integer comprobante) {
        this.comprobante = comprobante;
    }

    public Float getCapital() {
        return capital;
    }

    public void setCapital(Float capital) {
        this.capital = capital;
    }

    public Integer getCuota() {
        return cuota;
    }

    public void setCuota(Integer cuota) {
        this.cuota = cuota;
    }

    public Float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Float getMontoXcuota() {
        return montoXcuota;
    }

    public void setMontoXcuota(Float montoXcuota) {
        this.montoXcuota = montoXcuota;
    }

    public Float getIntXcuota() {
        return intXcuota;
    }

    public void setIntXcuota(Float intXcuota) {
        this.intXcuota = intXcuota;
    }

    public Date getFechaCredito() {
        return fechaCredito;
    }

    public void setFechaCredito(Date fechaCredito) {
        this.fechaCredito = fechaCredito;
    }

    public Date getFechaVto1() {
        return fechaVto1;
    }

    public void setFechaVto1(Date fechaVto1) {
        this.fechaVto1 = fechaVto1;
    }

    public Date getFechaVto2() {
        return fechaVto2;
    }

    public void setFechaVto2(Date fechaVto2) {
        this.fechaVto2 = fechaVto2;
    }

    public Date getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public Float getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(Float montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getCancelado() {
        return cancelado;
    }

    public void setCancelado(String cancelado) {
        this.cancelado = cancelado;
    }

    public Float getDebe() {
        return debe;
    }

    public void setDebe(Float debe) {
        this.debe = debe;
    }

    public Float getIntXmora() {
        return intXmora;
    }

    public void setIntXmora(Float intXmora) {
        this.intXmora = intXmora;
    }

    @XmlTransient
    public List<Plan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCredito != null ? idCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credito)) {
            return false;
        }
        Credito other = (Credito) object;
        if ((this.idCredito == null && other.idCredito != null) || (this.idCredito != null && !this.idCredito.equals(other.idCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Credito[ idCredito=" + idCredito + " ]";
    }
    
}
