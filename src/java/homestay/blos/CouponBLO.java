/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.blos;

import homestay.entities.Coupons;
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
public class CouponBLO implements Serializable {

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

    public List<Coupons> showAllCoupons() throws Exception {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Coupons.findAll").getResultList();
    }

    public List<String> getCouponIdByDate(String checkIn, String checkOut) throws Exception {
        EntityManager em = emf.createEntityManager();
        String sql = "Select c.couponId From Coupons c Where c.beginDate <= :checkIn And c.endDate >= :checkOut";

        Query query = em.createQuery(sql);
        query.setParameter("checkIn", checkIn);
        query.setParameter("checkOut", checkOut);
        return query.getResultList();
    }

    public double getDiscount(String couponId) throws Exception {
        EntityManager em = emf.createEntityManager();
        return em.find(Coupons.class, couponId).getDiscountRate();
    }

    public boolean delete(String couponId) throws Exception {
        EntityManager em = emf.createEntityManager();
        //Get coupons is not in use
        String sql = "Select c.couponId From Coupons c Where c.couponId Not In (Select b.couponId From Booking b Where b.complete = 'false')";
        List<String> couponIds = em.createQuery(sql).getResultList();
        if (couponIds.contains(couponId)) {
            Coupons coupon = em.find(Coupons.class, couponId);
            em.getTransaction().begin();
            em.remove(coupon);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean insert(String couponId, String couponName, double discountRate, String beginDate, String endDate) throws Exception {
        EntityManager em = emf.createEntityManager();
        Coupons coupon = em.find(Coupons.class, couponId);
        if (coupon == null) {
            coupon = new Coupons(couponId, couponName, discountRate, beginDate, endDate);
            em.getTransaction().begin();
            em.persist(coupon);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

}
