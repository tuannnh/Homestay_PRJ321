/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.blos;

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
public class UserBLO implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomestayManagementPU");

    public UserBLO() {
    }

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

    public String checkLogin(String username, String password) throws Exception {
        String role = "failed";
        EntityManager em = emf.createEntityManager();
        String sql = "Select u From Users u Where u.username = :username And u.password =:password And u.active =:active";
        Query qr = em.createQuery(sql);
        qr.setParameter("username", username);
        qr.setParameter("password", password);
        qr.setParameter("active", true);

        if (qr.getResultList().size() > 0) {
            role = ((Users) qr.getSingleResult()).getRole();
        }
        return role;
    }

    public List<Users> showAllUser() throws Exception {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Users.findAll", Users.class).getResultList();
    }

    public Users findByPrimaryKey(String username) throws Exception {
        EntityManager em = emf.createEntityManager();
        return em.find(Users.class, username);
    }

    public List<Users> findByLikeName(String search) throws Exception {

        EntityManager em = emf.createEntityManager();
        String sql = "Select u From Users u Where u.fullname Like :fullname";
        Query query = em.createQuery(sql);
        query.setParameter("fullname", "%" + search + "%");

        return query.getResultList();
    }

    public void delete(String username) throws Exception {
        EntityManager em = emf.createEntityManager();
        Users user = em.find(Users.class, username);
        if (user.isActive()) {
            user.setActive(false);
        } else {
            user.setActive(true);
        }
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void update(String username, String password, String fullname) throws Exception {
        EntityManager em = emf.createEntityManager();
        Users user = em.find(Users.class, username);
        user.setFullname(fullname);
        user.setPassword(password);
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void update(String username, String role) throws Exception {
        EntityManager em = emf.createEntityManager();
        Users user = em.find(Users.class, username);
        user.setRole(role);
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public boolean insert(String username, String password, String fullname, String role) throws Exception {
        boolean check = false;
        EntityManager em = emf.createEntityManager();
        Users newUser = em.find(Users.class, username);
        if (newUser == null) {
            newUser = new Users(username, password, fullname, role, true);
            em.getTransaction().begin();
            em.persist(newUser);
            em.getTransaction().commit();
            check = true;
        }
        return check;
    }

    public boolean insert(String username, String password, String fullname) throws Exception {
        boolean check = false;
        EntityManager em = emf.createEntityManager();
        Users newUser = em.find(Users.class, username);
        if (newUser == null) {
            newUser = new Users(username, password, fullname, "user", true);
            em.getTransaction().begin();
            em.persist(newUser);
            em.getTransaction().commit();
            check = true;
        }
        return check;
    }
}
