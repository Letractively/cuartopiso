package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoCredito")
    private Long idTipoCredito;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tasa")
    private Double tasa;
    @Column(name = "gastos")
    private Double gastos;
    @Column(name = "sellado")
    private Double sellado;
    @Column(name = "comision")
    private Double comision;
    @Column(name = "estado")
    private String estado;
    @OneToMany
    private List<Solicitud> creditoList;

    public TipoCredito() {
    }

    public TipoCredito(Long idTipoCredito) {
        this.idTipoCredito = idTipoCredito;
    }

    public Long getIdTipoCredito() {
        return idTipoCredito;
    }

    public void setIdTipoCredito(Long idTipoCredito) {
        this.idTipoCredito = idTipoCredito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Solicitud> getCreditoList() {
        return creditoList;
    }

    public void setCreditoList(List<Solicitud> creditoList) {
        this.creditoList = creditoList;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getGastos() {
        return gastos;
    }

    public void setGastos(Double gastos) {
        this.gastos = gastos;
    }

    public Double getSellado() {
        return sellado;
    }

    public void setSellado(Double sellado) {
        this.sellado = sellado;
    }

    public Double getTasa() {
        return tasa;
    }

    public void setTasa(Double tasa) {
        this.tasa = tasa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCredito != null ? idTipoCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCredito)) {
            return false;
        }
        TipoCredito other = (TipoCredito) object;
        if ((this.idTipoCredito == null && other.idTipoCredito != null) || (this.idTipoCredito != null && !this.idTipoCredito.equals(other.idTipoCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tipocredito[ idTipoCredito=" + idTipoCredito + " ]";
    }
}
