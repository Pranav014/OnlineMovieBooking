package com.neu.edu.moviebookingsystem.services;

import com.neu.edu.moviebookingsystem.DAO.IDao;
import com.neu.edu.moviebookingsystem.DAO.UserDao;
import com.neu.edu.moviebookingsystem.model.User;

import java.util.List;

public class UserService implements IService<User> {
    @Override
    public boolean save(User user) {
        IDao uDao = new UserDao();
        uDao.create(user);
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<User> getData() {
        IDao uDao = new UserDao();
        return uDao.getAllData();
    }
}
