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
@Table(name = "Rooms", catalog = "HomeStay", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rooms.findAll", query = "SELECT r FROM Rooms r"),
    @NamedQuery(name = "Rooms.findByRoomNo", query = "SELECT r FROM Rooms r WHERE r.roomNo = :roomNo"),
    @NamedQuery(name = "Rooms.findByRoomType", query = "SELECT r FROM Rooms r WHERE r.roomType = :roomType")})
public class Rooms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RoomNo", nullable = false, length = 3)
    private String roomNo;
    @Basic(optional = false)
    @Column(name = "RoomType", nullable = false, length = 15)
    private String roomType;

    public Rooms() {
    }

    public Rooms(String roomNo) {
        this.roomNo = roomNo;
    }

    public Rooms(String roomNo, String roomType) {
        this.roomNo = roomNo;
        this.roomType = roomType;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomNo != null ? roomNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rooms)) {
            return false;
        }
        Rooms other = (Rooms) object;
        if ((this.roomNo == null && other.roomNo != null) || (this.roomNo != null && !this.roomNo.equals(other.roomNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "homestay.entities.Rooms[ roomNo=" + roomNo + " ]";
    }
    
}
