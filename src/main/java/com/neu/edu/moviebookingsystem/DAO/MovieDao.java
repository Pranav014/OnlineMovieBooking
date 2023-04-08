package com.neu.edu.moviebookingsystem.DAO;

import com.neu.edu.moviebookingsystem.model.Movie;
import org.hibernate.HibernateException;

public class MovieDao extends Dao implements IDao<Movie>{
    @Override
    public boolean create(Movie movie) {
        try {
            //save user object in the database
            System.out.println("USerDAO");
            begin();
            getSession().persist(movie); // save(user); // .save(user);
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

    @Override
    public boolean destroy(Long id) {
        try {
            //save user object in the database

            begin();
//            getSession().delete();
            commit();
            return true;
        } catch (HibernateException e) {
            rollback();
            return false;
            //throw new AdException("Could not create user " + username, e);
//            throw new UserException("Exception while deleting user: " + e.getMessage());
        }
    }
}
