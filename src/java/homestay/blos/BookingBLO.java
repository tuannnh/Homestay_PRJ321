/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.blos;

import homestay.entities.Booking;
import homestay.entities.BookingMap;
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
public class BookingBLO implements Serializable {

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

    public List<Booking> findByLikeName(String search) throws Exception {

        EntityManager em = emf.createEntityManager();
        String sql = "Select b From Booking b Where b.fullname Like :fullname And b.complete = :completeStatus";
        Query query = em.createQuery(sql);
        boolean completeStatus = false;

        query.setParameter("fullname", "%" + search + "%");
        query.setParameter("completeStatus", completeStatus);
     

        return query.getResultList();
    }

    public List<Booking> findByUsername(String username) throws Exception {
        EntityManager em = emf.createEntityManager();
        boolean completeStatus = false;
        String sql = "Select b From Booking b Where b.username = :username And b.complete = :completeStatus";
        Query query = em.createQuery(sql);
        query.setParameter("username", username);
        query.setParameter("completeStatus", completeStatus);
        return query.getResultList();
    }

    public Booking findByPrimaryKey(int bookingId) throws Exception {
        EntityManager em = emf.createEntityManager();
        return em.find(Booking.class, bookingId);
    }

    public boolean delete(int bookingId) throws Exception {
        EntityManager em = emf.createEntityManager();
        boolean check = false;

        Booking booking = em.find(Booking.class, bookingId);
        if (booking != null) {
            em.getTransaction().begin();
            em.remove(booking);
            check = deleteBookingRooms(bookingId);
            em.getTransaction().commit();
        }
        return check;
    }

    public boolean deleteBookingRooms(int bookingId) throws Exception {
        EntityManager em = emf.createEntityManager();

        List<BookingMap> bookings = em.createNamedQuery("BookingMap.findByBookingId", BookingMap.class).setParameter("bookingId", bookingId).getResultList();
        em.getTransaction().begin();
        for (BookingMap bookingRecord : bookings) {
            em.remove(bookingRecord);
        }
        em.getTransaction().commit();

        return true;
    }

    public boolean update(int bookingId, String username, String checkin, String checkout, String fullname, int people, String couponId, String phone) throws Exception {
        boolean check = false;
        EntityManager em = emf.createEntityManager();

        Booking booking = em.find(Booking.class, bookingId);
        if (booking != null) {

            booking.setUsername(username);
            booking.setCheckIn(checkin);
            booking.setCheckOut(checkout);
            booking.setPeople(people);
            booking.setCouponId(couponId);
            booking.setPhone(phone);
            booking.setFullname(fullname);

            em.getTransaction().begin();
            em.merge(booking);
            check = deleteBookingRooms(bookingId);
            em.getTransaction().commit();

        }

        return check;
    }

    public boolean insertBookingRoom(int bookingId, String roomNo) throws Exception {

        EntityManager em = emf.createEntityManager();

        BookingMap bm = new BookingMap(bookingId, roomNo);
        em.getTransaction().begin();
        em.persist(bm);
        em.getTransaction().commit();
        return true;
    }

    public int insert(String username, String checkIn, String checkOut, int people, String couponId, String fullname, String phone) throws Exception {
        EntityManager em = emf.createEntityManager();

        Booking newBooking = new Booking(username, checkIn, checkOut, people, couponId, fullname, phone);
        em.getTransaction().begin();
        em.persist(newBooking);
        em.getTransaction().commit();
        int bookingId = newBooking.getBookingId();

        return bookingId;
    }

    public boolean completeBooking(Booking booking, boolean completeStatus) throws Exception {
        EntityManager em = emf.createEntityManager();
        booking.setComplete(completeStatus);
        em.getTransaction().begin();
        em.merge(booking);
        em.getTransaction().commit();
        return true;
    }
}
