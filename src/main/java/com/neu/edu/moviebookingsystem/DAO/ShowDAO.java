package com.neu.edu.moviebookingsystem.DAO;

import com.neu.edu.moviebookingsystem.Entities.Shows;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Component
@Configurable
public class ShowDAO extends Dao{
    private static final Logger logger = Logger.getAnonymousLogger();


    public List<Shows> getShows(){
        try{
            begin();
            Date d = java.sql.Date.valueOf(LocalDate.now());
            List<Shows> list = getSession().createQuery("from Shows  where date >= :date").setParameter("date", d).getResultList();

            close();
            logger.info("RETRIEVED LIST");
            return list;
        } catch (Exception e) {
            logger.info("ERROR in GETSHOWS " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public Shows getAShow(long show_id) {
        try{
            begin();
            Shows s = getSession().find(Shows.class, show_id);
            close();
            return s;
        } catch (Exception e) {
            throw new RuntimeException("ERROR in getAShow " + e.getMessage());
        }
    }

    public void updateShow(Shows show) {
        try{
            begin();
            getSession().update(show);
            close();
        } catch (Exception e) {
            throw new RuntimeException("ERROR IN UPDATE SHOW " + e.getMessage());
        }

    }
}
