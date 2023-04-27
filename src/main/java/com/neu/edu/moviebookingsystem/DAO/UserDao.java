package com.neu.edu.moviebookingsystem.DAO;

import com.neu.edu.moviebookingsystem.Util.HibernateUtil;
import com.neu.edu.moviebookingsystem.Entities.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
public class UserDao extends Dao {

    public boolean create(User user) {
        try {
            //save user object in the database
            System.out.println("UserDao");
            begin();
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
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
                System.out.println("User " + user.getId() + " Deleted");
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


    public User findByUsername(String username){
        try{
//            begin();
            User user = (User) getSession().createQuery("from User where username = :username", User.class).setParameter("username", username).uniqueResult();
            System.out.println(user.getUsername() + " USERNAME AFTER FINDING ");
//            close();
            return user;


        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }





}
