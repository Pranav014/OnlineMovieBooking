package com.neu.edu.moviebookingsystem.DAO;

import com.neu.edu.moviebookingsystem.model.User;
import org.hibernate.HibernateException;

import javax.persistence.Query;
import java.util.List;

public class UserDao extends Dao implements IDao<User> {

    @Override
    public boolean create(User user) {
        try {
            //save user object in the database
            System.out.println("USerDAO");
            begin();
            getSession().persist(user); // save(user); // .save(user);
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
        return false;
    }

    @Override
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
}
