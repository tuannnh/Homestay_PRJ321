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
@Table(name = "Booking", catalog = "HomeStay", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBookingId", query = "SELECT b FROM Booking b WHERE b.bookingId = :bookingId"),
    @NamedQuery(name = "Booking.findByUsername", query = "SELECT b FROM Booking b WHERE b.username = :username"),
    @NamedQuery(name = "Booking.findByCheckIn", query = "SELECT b FROM Booking b WHERE b.checkIn = :checkIn"),
    @NamedQuery(name = "Booking.findByCheckOut", query = "SELECT b FROM Booking b WHERE b.checkOut = :checkOut"),
    @NamedQuery(name = "Booking.findByPeople", query = "SELECT b FROM Booking b WHERE b.people = :people"),
    @NamedQuery(name = "Booking.findByCouponId", query = "SELECT b FROM Booking b WHERE b.couponId = :couponId"),
    @NamedQuery(name = "Booking.findByPhone", query = "SELECT b FROM Booking b WHERE b.phone = :phone"),
    @NamedQuery(name = "Booking.findByFullname", query = "SELECT b FROM Booking b WHERE b.fullname = :fullname")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)
    @Column(name = "BookingId", nullable = false)
    private Integer bookingId;
    @Basic(optional = false)
    @Column(name = "Username", nullable = false, length = 20)
    private String username;
    @Basic(optional = false)
    @Column(name = "checkIn", nullable = false, length = 10)
    private String checkIn;
    @Basic(optional = false)
    @Column(name = "checkOut", nullable = false, length = 10)
    private String checkOut;
    @Basic(optional = false)
    @Column(name = "People", nullable = false)
    private int people;
    @Column(name = "CouponId", length = 15)
    private String couponId;
    @Basic(optional = false)
    @Column(name = "Phone", nullable = false)
    private String phone;
    @Basic(optional = false)
    @Column(name = "Fullname", nullable = false, length = 30)
    private String fullname;
    @Column(name = "Complete", nullable = false, length = 30)
    private boolean complete;

    public Booking() {
    }

    public Booking(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Booking(String username, String checkIn, String checkOut, int people,String couponId, String fullname, String phone) {
        this.username = username;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.people = people;
        this.couponId = couponId;
        this.phone = phone;
        this.fullname = fullname;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCheckIn() {
        String[] checkInDate = checkIn.split("-");
        String s = checkInDate[2] + "/" + checkInDate[1] + "/" + checkInDate[0];
        return s;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        String[] checkOutDate = checkOut.split("-");
        String s = checkOutDate[2] + "/" + checkOutDate[1] + "/" + checkOutDate[0];
        return s;
    }

    public void setCheckOut(String checkOut) {

        this.checkOut = checkOut;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "homestay.entities.Booking[ bookingId=" + bookingId + " ]";
    }

}
