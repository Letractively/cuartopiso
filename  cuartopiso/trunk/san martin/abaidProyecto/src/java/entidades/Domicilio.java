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
@Table(name = "domicilio", catalog = "abaidposta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d"),
    @NamedQuery(name = "Domicilio.findByIdDomicilio", query = "SELECT d FROM Domicilio d WHERE d.idDomicilio = :idDomicilio"),
    @NamedQuery(name = "Domicilio.findByCalle", query = "SELECT d FROM Domicilio d WHERE d.calle = :calle"),
    @NamedQuery(name = "Domicilio.findByNumero", query = "SELECT d FROM Domicilio d WHERE d.numero = :numero"),
    @NamedQuery(name = "Domicilio.findByBarrio", query = "SELECT d FROM Domicilio d WHERE d.barrio = :barrio"),
    @NamedQuery(name = "Domicilio.findByPiso", query = "SELECT d FROM Domicilio d WHERE d.piso = :piso"),
    @NamedQuery(name = "Domicilio.findByLocalidad", query = "SELECT d FROM Domicilio d WHERE d.localidad = :localidad"),
    @NamedQuery(name = "Domicilio.findByCodigoPostal", query = "SELECT d FROM Domicilio d WHERE d.codigoPostal = :codigoPostal"),
    @NamedQuery(name = "Domicilio.findByDpto", query = "SELECT d FROM Domicilio d WHERE d.dpto = :dpto"),
    @NamedQuery(name = "Domicilio.findByManzana", query = "SELECT d FROM Domicilio d WHERE d.manzana = :manzana"),
    @NamedQuery(name = "Domicilio.findByCasa", query = "SELECT d FROM Domicilio d WHERE d.casa = :casa"),
    @NamedQuery(name = "Domicilio.findByProvincia", query = "SELECT d FROM Domicilio d WHERE d.provincia = :provincia"),
    @NamedQuery(name = "Domicilio.findByObservacion", query = "SELECT d FROM Domicilio d WHERE d.observacion = :observacion")})
public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDomicilio")
    private Integer idDomicilio;
    @Size(max = 10)
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 10)
    @Column(name = "barrio")
    private String barrio;
    @Column(name = "piso")
    private Integer piso;
    @Size(max = 10)
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "codigoPostal")
    private Integer codigoPostal;
    @Column(name = "dpto")
    private Integer dpto;
    @Size(max = 10)
    @Column(name = "manzana")
    private String manzana;
    @Column(name = "casa")
    private Integer casa;
    @Size(max = 10)
    @Column(name = "provincia")
    private String provincia;
    @Size(max = 10)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente idCliente;

    public Domicilio() {
    }

    public Domicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Integer getDpto() {
        return dpto;
    }

    public void setDpto(Integer dpto) {
        this.dpto = dpto;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public Integer getCasa() {
        return casa;
    }

    public void setCasa(Integer casa) {
        this.casa = casa;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
