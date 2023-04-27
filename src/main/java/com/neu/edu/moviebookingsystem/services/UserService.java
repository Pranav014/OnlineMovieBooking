package com.neu.edu.moviebookingsystem.services;

import com.neu.edu.moviebookingsystem.DAO.UserDao;
import com.neu.edu.moviebookingsystem.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
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
        User user1 = userDao.findByUsername(user.getUsername());
        if (user1 != null){
            return false;
        }
        userDao.create(user);
        return true;
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

    public User findByUsername(String username) {
        return userDao.findByUsername(username);

    }

}
