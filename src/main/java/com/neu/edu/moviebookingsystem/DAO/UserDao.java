package com.neu.edu.moviebookingsystem.DAO;

import com.neu.edu.moviebookingsystem.Util.HibernateUtil;
import com.neu.edu.moviebookingsystem.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Configurable
public class UserDao {
    private static final Logger logger = Logger.getAnonymousLogger();
    private static final ThreadLocal sessionThread = new ThreadLocal();
    private static final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    final
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserDao(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static Session getSession() {
        Session session = (Session) UserDao.sessionThread.get();

        if (session == null) {
            session = sessionFactory.openSession();
            UserDao.sessionThread.set(session);
        }
        logger.info("Session created");
        return session;
    }

    public static void begin() {
        getSession().beginTransaction();
        logger.info("BEGIN SESSION");
    }

    public static void commit() {
        try{
            getSession().getTransaction().commit();
            logger.info("COMMIT");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            logger.info("EXCEPTION IN COMMIT");

        }


    }

    public static void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            logger.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            logger.log(Level.WARNING, "Cannot close", e);
        }
        UserDao.sessionThread.set(null);
    }

    public static void close() {
        getSession().close();
        UserDao.sessionThread.set(null);
    }


    public boolean create(User user) {
        try {
            //save user object in the database
            System.out.println("UserDao");
            begin();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            getSession().persist(user);  // save(user); // .save(user);
            commit();
            close();
            return true;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            rollback();
            return false;
            // throw new AdException("Could not create user " + username, e);
//            throw new UserException("Exception while creating user: " + e.getMessage());
        }
    }

    public boolean destroy(Long id) {
        try{
            begin();
            User user = getSession().get(User.class, id);
            if (user != null){
                getSession().delete(user);
                System.out.println("User " + user.getUserID() + " Deleted");
            }
            commit();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    public List<User> getAllData() {
        try{
            begin();
            List<User> result =  getSession().createQuery(" from User", User.class).getResultList();
//            System.out.println(result.getResultList());
            commit();
            return result;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public User update(long id, User user) {
        try{
            begin();
            User dUser = getSession().load(User.class, id);
            dUser.setFirstName(user.getFirstName());
            dUser.setLastName(user.getLastName());
            dUser.setUsername(user.getUsername());
            dUser.setPassword(user.getPassword());

            getSession().update(dUser);
            commit();
            return user;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            User u = new User();
            u.setFirstName("Error");
            return u;
        }

    }


    public UserDetailsService findByUsername(String username){
        try{
            begin();
            User user = getSession().createQuery("from User where username = " + username, User.class).uniqueResult();
            commit();
            return (UserDetailsService) user;


        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }


    public boolean find(Long id) {
        try{
            begin();
            User user = getSession().get(User.class, id);
            if (user != null){
                return true;
            }
            return false;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


}
