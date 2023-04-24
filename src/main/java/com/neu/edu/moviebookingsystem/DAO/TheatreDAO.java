package com.neu.edu.moviebookingsystem.DAO;

import com.neu.edu.moviebookingsystem.Util.HibernateUtil;
import com.neu.edu.moviebookingsystem.Entities.Theatre;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TheatreDAO {
    private static final Logger logger = Logger.getAnonymousLogger();
    private static final ThreadLocal sessionThread = new ThreadLocal();
    private static final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    public TheatreDAO() {
    }

    public static Session getSession() {
        Session session = (Session) TheatreDAO.sessionThread.get();

        if (session == null) {
            session = sessionFactory.openSession();
            TheatreDAO.sessionThread.set(session);
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
        TheatreDAO.sessionThread.set(null);
    }

    public static void close() {
        getSession().close();
        TheatreDAO.sessionThread.set(null);
    }

    /**
     * Saves Theatre to database
     * @param theatre
     * @return boolean
     */
    public boolean create(Theatre theatre) {
        try {
            System.out.println("USerDAO");
            TheatreDAO.begin();
            TheatreDAO.getSession().persist(theatre); // save(user); // .save(user);
            TheatreDAO.commit();
            TheatreDAO.close();
            return true;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            TheatreDAO.rollback();
            return false;
            // throw new AdException("Could not create user " + username, e);
//            throw new UserException("Exception while creating user: " + e.getMessage());
        }
    }

    /**
     *
     * Deletes Theatre using id from database
     * @param id
     * @return boolean
     */
    public boolean destroy(Long id) {
        try {
            //save user object in the database
            TheatreDAO.begin();
            Theatre theatre = getSession().get(Theatre.class, id);

            if (theatre != null){
                getSession().delete(theatre);
                System.out.println("Theatre " + theatre.getId() + " Deleted");
            }
//            getSession().delete(id);
            TheatreDAO.commit();
            return true;
        } catch (HibernateException e) {
            TheatreDAO.rollback();
            return false;
            //throw new AdException("Could not create user " + username, e);
//            throw new UserException("Exception while deleting user: " + e.getMessage());
        }
    }

    /**
     *
     * @return List of movies
     */
    public List<Theatre> getAllData() {
        try{
            TheatreDAO.begin();
            List<Theatre> result =  TheatreDAO.getSession().createQuery("from Theatre").getResultList();
            TheatreDAO.commit();
            return result;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }


    }

    /**
     *
     * Updates Theatre details
     * @param id
     * @param theatre
     * @return Theatre
     */
    public Theatre update(long id, Theatre theatre) {
        try {
            logger.info("BEGIN UPDATE");
            begin();
            Theatre t = getSession().get(Theatre.class, id);
            t.setTheatreName(theatre.getTheatreName());
            t.setTheatreLocation(t.getTheatreLocation());
            getSession().update(t);
            commit();
            close();
            logger.info("THEATRE UPDATED");
            return t;
        } catch (Exception e) {
            logger.info("ERROR IN UPDATE" + e.getMessage());
            throw new RuntimeException(e);

        }
    }

    /**
     * Finds a specific Theatre using ID
     * @param id
     * @return Theatre
     */

    public Theatre find(Long id) {
        try{
            logger.info("BEGIN FIND");
            begin();
            Theatre t = getSession().find(Theatre.class, id);
            close();
            logger.info("CLOSE FIND");
            return t;
        } catch (Exception e) {
            logger.info("ERROR in FIND");
            throw new RuntimeException(e);
        }
    }

    public Theatre findByName(String name) {
        try{
//            begin();
            Theatre theatre =  getSession().createQuery("from Theatre where movieName = :name", Theatre.class).setParameter("name", name).uniqueResult();
            System.out.println(theatre.getTheatreName() + " USERNAME AFTER FINDING ");
//            close();
            return theatre;


        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
