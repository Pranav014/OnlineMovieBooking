package com.neu.edu.moviebookingsystem.DAO;

import com.neu.edu.moviebookingsystem.Entities.Movie;
import com.neu.edu.moviebookingsystem.model.User;

import java.util.List;

public interface IUserDAO {
    boolean create(User user);

    boolean destroy(Long id);

    List<User> getAllData();

    Movie update(long id, User user);

    boolean find(Long id);

}
