//package com.neu.edu.moviebookingsystem.DAO;
//
//import com.neu.edu.moviebookingsystem.Util.HibernateUtil;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class MovieDAOFactory extends DAOFactory{
//    private static final Logger logger = Logger.getAnonymousLogger();
//    private static final ThreadLocal sessionThread = new ThreadLocal();
//    private static final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
//    public MovieDAOFactory() {
//    }
//
//    public static Session getSession() {
//        Session session = (Session) MovieDAOFactory.sessionThread.get();
//
//        if (session == null) {
//            session = sessionFactory.openSession();
//            MovieDAOFactory.sessionThread.set(session);
//        }
//        logger.info("Session created");
//        return session;
//    }
//
//    public static void begin() {
//        getSession().beginTransaction();
//        logger.info("BEGIN SESSION");
//    }
//
//    public static void commit() {
//        try{
//            getSession().getTransaction().commit();
//            logger.info("COMMIT");
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//            logger.info("EXCEPTION IN COMMIT");
//
//        }
//
//
//    }
//
//    public void rollback() {
//        try {
//            getSession().getTransaction().rollback();
//        } catch (HibernateException e) {
//            logger.log(Level.WARNING, "Cannot rollback", e);
//        }
//        try {
//            getSession().close();
//        } catch (HibernateException e) {
//            logger.log(Level.WARNING, "Cannot close", e);
//        }
//        MovieDAOFactory.sessionThread.set(null);
//    }
//
//    public static void close() {
//        getSession().close();
//        MovieDAOFactory.sessionThread.set(null);
//    }
//
//
//    @Override
//    public MovieDao getMovieDao() {
//        return new MovieDao();
//    }
//}
