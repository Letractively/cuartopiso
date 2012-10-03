/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablonello
 */
@Entity
@Table(name = "DISCOUNT_CODE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigoDiscontinuos.findAll", query = "SELECT c FROM CodigoDiscontinuos c"),
    @NamedQuery(name = "CodigoDiscontinuos.findByDiscountCode", query = "SELECT c FROM CodigoDiscontinuos c WHERE c.discountCode = :discountCode"),
    @NamedQuery(name = "CodigoDiscontinuos.findByRate", query = "SELECT c FROM CodigoDiscontinuos c WHERE c.rate = :rate")})
public class CodigoDiscontinuos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISCOUNT_CODE")
    private Character discountCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RATE")
    private BigDecimal rate;

    public CodigoDiscontinuos() {
    }

    public CodigoDiscontinuos(Character discountCode) {
        this.discountCode = discountCode;
    }

    public Character getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(Character discountCode) {
        this.discountCode = discountCode;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discountCode != null ? discountCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigoDiscontinuos)) {
            return false;
        }
        CodigoDiscontinuos other = (CodigoDiscontinuos) object;
        if ((this.discountCode == null && other.discountCode != null) || (this.discountCode != null && !this.discountCode.equals(other.discountCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "server.CodigoDiscontinuos[ discountCode=" + discountCode + " ]";
    }
    
}
