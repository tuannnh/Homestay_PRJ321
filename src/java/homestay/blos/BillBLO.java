/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.blos;

import homestay.entities.Bills;
import homestay.entities.Booking;
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
public class BillBLO implements Serializable {

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

    public List<Bills> findByLikeName(String search) throws Exception {

        EntityManager em = emf.createEntityManager();
        String sql = "Select b From Bills b Where b.fullname Like :fullname";
        Query query = em.createQuery(sql);
        query.setParameter("fullname", "%" + search + "%");

        return query.getResultList();
    }
    
 
    public List<Bills> findByUsername(String username) throws Exception {
        EntityManager em = emf.createEntityManager();
        String sql = "Select b from Bills b Where b.bookingId In (Select booking.bookingId From Booking booking Where booking.username = :username)";
        return em.createQuery(sql).setParameter("username", username).getResultList();
    }

    public boolean insert(int bookingId, String fullname, boolean bbq, boolean bike, boolean breakfast, String completeDate, String checkoutBy, double total) throws Exception {
        EntityManager em = emf.createEntityManager();
        String sql =  "Select b.bookingId From Bills b Where b.bookingId = :bookingId";
        List<String> ids = em.createQuery(sql).setParameter("bookingId", bookingId).getResultList();
        if (ids.contains(bookingId)) {
            return false;
        }
        Bills newBill = new Bills(bookingId, fullname, bbq, bike, breakfast, completeDate, checkoutBy, total);
        em.getTransaction().begin();
        em.persist(newBill);
        em.getTransaction().commit();

        return newBill.getBillId() > 0;
    }

}
