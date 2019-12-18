/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tuannnh
 */
@Entity
@Table(name = "Coupons", catalog = "HomeStay", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coupons.findAll", query = "SELECT c FROM Coupons c"),
    @NamedQuery(name = "Coupons.findByCouponId", query = "SELECT c FROM Coupons c WHERE c.couponId = :couponId"),
    @NamedQuery(name = "Coupons.findByCouponName", query = "SELECT c FROM Coupons c WHERE c.couponName = :couponName"),
    @NamedQuery(name = "Coupons.findByDiscountRate", query = "SELECT c FROM Coupons c WHERE c.discountRate = :discountRate"),
    @NamedQuery(name = "Coupons.findByBeginDate", query = "SELECT c FROM Coupons c WHERE c.beginDate = :beginDate"),
    @NamedQuery(name = "Coupons.findByEndDate", query = "SELECT c FROM Coupons c WHERE c.endDate = :endDate")})
public class Coupons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CouponId", nullable = false, length = 10)
    private String couponId;
    @Basic(optional = false)
    @Column(name = "CouponName", nullable = false, length = 30)
    private String couponName;
    @Basic(optional = false)
    @Column(name = "DiscountRate", nullable = false)
    private double discountRate;
    @Column(name = "BeginDate", nullable = false, length = 10)
    private String beginDate;
    @Column(name = "EndDate", nullable = false, length = 10)
    private String endDate;

    public Coupons() {
    }

    public Coupons(String couponId) {
        this.couponId = couponId;
    }

    public Coupons(String couponId, String couponName, double discountRate, String beginDate, String endDate) {
        this.couponId = couponId;
        this.couponName = couponName;
        this.discountRate = discountRate;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public String getBeginDate() {
        String[] date = beginDate.split("-");
        String s = date[2] + "/" + date[1] + "/" + date[0];
        return s;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        String[] date = endDate.split("-");
        String s = date[2] + "/" + date[1] + "/" + date[0];
        return s;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (couponId != null ? couponId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coupons)) {
            return false;
        }
        Coupons other = (Coupons) object;
        if ((this.couponId == null && other.couponId != null) || (this.couponId != null && !this.couponId.equals(other.couponId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "homestay.entities.Coupons[ couponId=" + couponId + " ]";
    }

}
