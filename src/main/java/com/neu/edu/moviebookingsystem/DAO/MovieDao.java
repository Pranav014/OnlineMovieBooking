package com.neu.edu.moviebookingsystem.DAO;

import com.neu.edu.moviebookingsystem.Util.HibernateUtil;
import com.neu.edu.moviebookingsystem.Entities.Movie;
import com.neu.edu.moviebookingsystem.Entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Configurable
public class MovieDao {
    private static final Logger logger = Logger.getAnonymousLogger();
    private static final ThreadLocal sessionThread = new ThreadLocal();
    private static final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    public MovieDao() {
    }

    public static Session getSession() {
        Session session = (Session) MovieDao.sessionThread.get();

        if (session == null) {
            session = sessionFactory.openSession();
            MovieDao.sessionThread.set(session);
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
        MovieDao.sessionThread.set(null);
    }

    public static void close() {
        getSession().close();
        MovieDao.sessionThread.set(null);
    }

    /**
     * Saves Movie to database
     * @param movie
     * @return boolean
     */
    public boolean create(Movie movie) {
        try {
            System.out.println("USerDAO");
            MovieDao.begin();
            MovieDao.getSession().persist(movie); // save(user); // .save(user);
            MovieDao.commit();
            MovieDao.close();
            return true;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            MovieDao.rollback();
            return false;
            // throw new AdException("Could not create user " + username, e);
//            throw new UserException("Exception while creating user: " + e.getMessage());
        }
    }

    /**
     *
     * Deletes Movie using id from database
     * @param id
     * @return boolean
     */
    public boolean destroy(Long id) {
        try {
            //save user object in the database
            MovieDao.begin();
            Movie movie = getSession().get(Movie.class, id);

            if (movie != null){
                getSession().delete(movie);
                System.out.println("Movie " + movie.getId() + " Deleted");
            }
//            getSession().delete(id);
            MovieDao.commit();
            return true;
        } catch (HibernateException e) {
            MovieDao.rollback();
            return false;
            //throw new AdException("Could not create user " + username, e);
//            throw new UserException("Exception while deleting user: " + e.getMessage());
        }
    }

    /**
     *
     * @return List of movies
     */
    public List<Movie> getAllData() {
        try{
            MovieDao.begin();
            List<Movie> result =  MovieDao.getSession().createQuery("from Movie").getResultList();
            MovieDao.commit();
            return result;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }


    }

    /**
     *
     * Updates Movie details
     * @param id
     * @param movie
     * @return Movie
     */
    public Movie update(long id, Movie movie) {
        try {
            logger.info("BEGIN UPDATE");
            begin();
            Movie m = getSession().get(Movie.class, id);
            m.setMovieName(movie.getMovieName());
            m.setDescription(m.getDescription());
            m.setLeadActor(movie.getLeadActor());
            m.setRuntime(movie.getRuntime());
            m.setTheatreoutdate(movie.getTheatreoutdate());
            m.setLeadActress(movie.getLeadActress());
            getSession().update(m);
            commit();
            close();
            logger.info("MOVIE UPDATED");
            return m;
        } catch (Exception e) {
            logger.info("ERROR IN UPDATE" + e.getMessage());
            throw new RuntimeException(e);

        }
    }

    /**
     * Finds a specific Movie using ID
     * @param id
     * @return Movie
     */

    public Movie find(Long id) {
        try{
            logger.info("BEGIN FIND");
            begin();
            Movie m = getSession().find(Movie.class, id);
            close();
            logger.info("CLOSE FIND");
            return m;
        } catch (Exception e) {
            logger.info("ERROR in FIND");
            throw new RuntimeException(e);
        }
    }

    public Movie findByName(String name) {
        try{
//            begin();
            Movie movie =  getSession().createQuery("from Movie where movieName = :name", Movie.class).setParameter("name", name).uniqueResult();
            System.out.println(movie.getMovieName() + " USERNAME AFTER FINDING ");
//            close();
            return movie;


        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
