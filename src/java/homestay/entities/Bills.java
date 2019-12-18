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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Bills", catalog = "HomeStay", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bills.findAll", query = "SELECT b FROM Bills b"),
    @NamedQuery(name = "Bills.findByBillId", query = "SELECT b FROM Bills b WHERE b.billId = :billId"),
    @NamedQuery(name = "Bills.findByBookingId", query = "SELECT b FROM Bills b WHERE b.bookingId = :bookingId"),
    @NamedQuery(name = "Bills.findByBbq", query = "SELECT b FROM Bills b WHERE b.bbq = :bbq"),
    @NamedQuery(name = "Bills.findByBike", query = "SELECT b FROM Bills b WHERE b.bike = :bike"),
    @NamedQuery(name = "Bills.findByBreakfast", query = "SELECT b FROM Bills b WHERE b.breakfast = :breakfast"),
    @NamedQuery(name = "Bills.findByCompleteDate", query = "SELECT b FROM Bills b WHERE b.completeDate = :completeDate"),
    @NamedQuery(name = "Bills.findByCheckoutBy", query = "SELECT b FROM Bills b WHERE b.checkoutBy = :checkoutBy"),
    @NamedQuery(name = "Bills.findByTotal", query = "SELECT b FROM Bills b WHERE b.total = :total"),
    @NamedQuery(name = "Bills.findByFullname", query = "SELECT b FROM Bills b WHERE b.fullname = :fullname")})
public class Bills implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)
    @Column(name = "BillId", nullable = false)
    private Integer billId;
    @Basic(optional = false)
    @Column(name = "BookingId", nullable = false)
    private int bookingId;
    @Basic(optional = false)
    @Column(name = "BBQ", nullable = false)
    private boolean bbq;
    @Basic(optional = false)
    @Column(name = "Bike", nullable = false)
    private boolean bike;
    @Basic(optional = false)
    @Column(name = "Breakfast", nullable = false)
    private boolean breakfast;
    @Basic(optional = false)
    @Column(name = "CompleteDate", nullable = false, length = 10)
    private String completeDate;
    @Basic(optional = false)
    @Column(name = "CheckoutBy", nullable = false, length = 30)
    private String checkoutBy;
    @Basic(optional = false)
    @Column(name = "Total", nullable = false)
    private double total;
    @Basic(optional = false)
    @Column(name = "Fullname", nullable = false, length = 30)
    private String fullname;

    public Bills() {
    }

    public Bills(Integer billId) {
        this.billId = billId;
    }

    public Bills(int bookingId, String fullname, boolean bbq, boolean bike, boolean breakfast, String completeDate, String checkoutBy, double total) {
        this.bookingId = bookingId;
        this.bbq = bbq;
        this.bike = bike;
        this.breakfast = breakfast;
        this.completeDate = completeDate;
        this.checkoutBy = checkoutBy;
        this.total = total;
        this.fullname = fullname;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public boolean getBbq() {
        return bbq;
    }

    public void setBbq(boolean bbq) {
        this.bbq = bbq;
    }

    public boolean getBike() {
        return bike;
    }

    public void setBike(boolean bike) {
        this.bike = bike;
    }

    public boolean getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public String getCompleteDate() {
        String[] complete = completeDate.split("-");
        String s = complete[2] + "/" + complete[1] + "/" + complete[0];
        return s;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public String getCheckoutBy() {
        return checkoutBy;
    }

    public void setCheckoutBy(String checkoutBy) {
        this.checkoutBy = checkoutBy;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billId != null ? billId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bills)) {
            return false;
        }
        Bills other = (Bills) object;
        if ((this.billId == null && other.billId != null) || (this.billId != null && !this.billId.equals(other.billId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "homestay.entities.Bills[ billId=" + billId + " ]";
    }

}
