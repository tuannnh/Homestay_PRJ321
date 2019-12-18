/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.blos;

import homestay.entities.Rooms;
import homestay.entities.Users;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author tuannnh
 */
public class RoomBLO implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomestayManagementPU");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Rooms> showAllRooms() throws Exception {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Rooms.findAll").getResultList();
    }

    public Rooms findByPrimaryKey(String roomNo) throws Exception {
        EntityManager em = emf.createEntityManager();
        return em.find(Rooms.class, roomNo);
    }

    public boolean insert(String roomNo, String roomType) throws Exception {
        boolean check = false;
        EntityManager em = emf.createEntityManager();
        Rooms room = em.find(Rooms.class, roomNo);
        if (room == null) {
            room = new Rooms(roomNo, roomType);
            em.getTransaction().begin();
            em.persist(room);
            em.getTransaction().commit();
            check = true;
        }
        return check;
    }

    public boolean delete(String roomNo) throws Exception {
        EntityManager em = emf.createEntityManager();
        String sql = "Select r.roomNo From Rooms r Where r.roomNo Not In (Select m.roomNo From Booking b JOIN BookingMap m ON b.bookingId = m.bookingId And b.complete = 'false')";
        Query qr = em.createQuery(sql);
        List<String> roomNoList = qr.getResultList();
        if (roomNoList.contains(roomNo)) {
            Rooms room = em.find(Rooms.class, roomNo);
            em.getTransaction().begin();
            em.remove(room);
            em.getTransaction().commit();
            return true;
        }

        return false;
    }

    public boolean update(String roomNo, String roomType) throws Exception {
        EntityManager em = emf.createEntityManager();
        String sql = "Select r.roomNo From Rooms r Where r.roomNo Not In (Select m.roomNo From Booking b JOIN BookingMap m ON b.bookingId = m.bookingId And b.complete = 'false')";
        List<String> roomNoList = em.createQuery(sql).getResultList();
        if (roomNoList.contains(roomNo)) {
            Rooms room = em.find(Rooms.class, roomNo);
            room.setRoomType(roomType);
            em.getTransaction().begin();
            em.merge(room);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    public List<Rooms> getEmptyRooms(String checkin, String checkout) throws Exception {
        EntityManager em = emf.createEntityManager();

        String sql = "Select r From Rooms r Where r.roomNo Not In (Select m.roomNo From Booking b JOIN BookingMap m ON b.bookingId = m.bookingId And b.complete = 'false' And b.checkIn <= :checkout And b.checkOut >= :checkin)";
        Query qr = em.createQuery(sql);
        qr.setParameter("checkin", checkin);
        qr.setParameter("checkout", checkout);
        return qr.getResultList();
    }

    public List<Rooms> getBookedRooms(int bookingId) throws Exception {
        EntityManager em = emf.createEntityManager();

        String sql = "Select r From Rooms r Where r.roomNo In (Select m.roomNo From BookingMap m Where m.bookingId = :bookingId)";
        Query qr = em.createQuery(sql);
        qr.setParameter("bookingId", bookingId);
        return qr.getResultList();
    }

}
