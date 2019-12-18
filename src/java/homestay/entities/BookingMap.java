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
@Table(name = "BookingMap", catalog = "HomeStay", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingMap.findAll", query = "SELECT b FROM BookingMap b"),
    @NamedQuery(name = "BookingMap.findById", query = "SELECT b FROM BookingMap b WHERE b.id = :id"),
    @NamedQuery(name = "BookingMap.findByBookingId", query = "SELECT b FROM BookingMap b WHERE b.bookingId = :bookingId"),
    @NamedQuery(name = "BookingMap.findByRoomNo", query = "SELECT b FROM BookingMap b WHERE b.roomNo = :roomNo")})
public class BookingMap implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "BookingId", nullable = false, length = 15)
    private int bookingId;
    @Basic(optional = false)
    @Column(name = "RoomNo", nullable = false, length = 3)
    private String roomNo;

    public BookingMap() {
    }

    public BookingMap(Integer id) {
        this.id = id;
    }

    public BookingMap(int bookingId, String roomNo) {

        this.bookingId = bookingId;
        this.roomNo = roomNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingMap)) {
            return false;
        }
        BookingMap other = (BookingMap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "homestay.entities.BookingMap[ id=" + id + " ]";
    }

}
