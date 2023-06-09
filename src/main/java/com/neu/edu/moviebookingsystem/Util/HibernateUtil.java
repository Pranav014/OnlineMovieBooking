package com.neu.edu.moviebookingsystem.Util;

import com.neu.edu.moviebookingsystem.Entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;
@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = {"com.neu.edu"})
public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        try {

            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/bookingsystem?createDatabaseIfNotExist=true&useSSL=false");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "root123");
            properties.put(Environment.FORMAT_SQL, "true");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            properties.put(Environment.POOL_SIZE, "5");

            return (SessionFactory) new Configuration()
                    .setProperties(properties)
                    .addAnnotatedClass(Movie.class).addAnnotatedClass(User.class).addAnnotatedClass(Shows.class)
                    .addAnnotatedClass(Theatre.class).addAnnotatedClass(Screens.class).addAnnotatedClass(Ticket.class)//.addAnnotatedClass(PlayList.class).addAnnotatedClass(Song.class).addAnnotatedClass(Album.class).addAnnotatedClass(Admin.class)
                    .buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("build SessionFactory failed :" + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }
}
