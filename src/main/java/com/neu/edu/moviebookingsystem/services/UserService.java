package com.neu.edu.moviebookingsystem.services;

import com.neu.edu.moviebookingsystem.DAO.UserDao;
import com.neu.edu.moviebookingsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public boolean save(User user) {
//        IDao userDao = new userDao();
        userDao.create(user);
        return false;
    }

    public boolean delete(Long id) {
        return userDao.destroy(id);

    }

    public List<User> getData() {
        return userDao.getAllData();
    }

    public User update(long id, User user) {
        return (User) userDao.update(id, user);
    }

    public UserDetailsService findByUsername(String username) {
        userDao.findByUsername(username);
        return null;
    }

}
