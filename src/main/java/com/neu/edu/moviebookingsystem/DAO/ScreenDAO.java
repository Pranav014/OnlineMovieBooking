package com.neu.edu.moviebookingsystem.DAO;

import com.neu.edu.moviebookingsystem.Entities.Screens;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Configurable
public class ScreenDAO extends Dao{

    public boolean create(Screens screen) {
        try {
            System.out.println("USerDAO");
            begin();
            getSession().persist(screen); // save(user); // .save(user);
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
        try {
            //save user object in the database
            begin();
            Screens screen = getSession().get(Screens.class, id);

            if (screen != null){
                getSession().delete(screen);
                System.out.println("Movie " + screen.getId() + " Deleted");
            }
//            getSession().delete(id);
            commit();
            return true;
        } catch (HibernateException e) {
            rollback();
            return false;
            //throw new AdException("Could not create user " + username, e);
//            throw new UserException("Exception while deleting user: " + e.getMessage());
        }
    }

    /**
     *
     * @return List of movies
     */
    public List<Screens> getAllData() {
        try{
            begin();
            List<Screens> result =  MovieDao.getSession().createQuery("from Screens ").getResultList();
            commit();
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
     * @param screen
     * @return Movie
     */
    public Screens update(long id, Screens screen) {
        try {
//            logger.info("BEGIN UPDATE");
            begin();
//            Screens screen1 = getSession().get(Screens.class, id);
//            screen1.setScreenNumber(screen.getScreenNumber());
//            screen1.setSeatNumber(screen.getSeatNumber());

            getSession().update(screen);
            commit();
            close();
//            logger.info("MOVIE UPDATED");
            return screen;
        } catch (Exception e) {
//            logger.info("ERROR IN UPDATE" + e.getMessage());
            throw new RuntimeException(e);

        }
    }

    public List<String > getScreenOfShow(long showid){
        try{
            begin();
            List<Screens> list = getSession().createQuery("from Screens where showsByShowId.showId = :showid and seatStatus = 0").setParameter("showid", showid).getResultList();
            List<String> seatNumbers = new ArrayList<>();
            for (Screens s : list){
                seatNumbers.add(s.getSeatNumber() + " Screen: " + s.getScreenNumber());
            }
            close();
            return seatNumbers;
        }
        catch (Exception e){
            throw new RuntimeException("ERROR HERE "  +  e.getMessage());
        }
    }

}
