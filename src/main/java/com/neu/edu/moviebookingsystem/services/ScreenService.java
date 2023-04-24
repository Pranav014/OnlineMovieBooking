package com.neu.edu.moviebookingsystem.services;

import com.neu.edu.moviebookingsystem.DAO.ScreenDAO;
import com.neu.edu.moviebookingsystem.Entities.Screens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class ScreenService {

    final ScreenDAO screenDAO;

    @Autowired
    public ScreenService(ScreenDAO screenDAO) {
        this.screenDAO = screenDAO;
    }

    public List<String> getShows(long id){
        return screenDAO.getScreenOfShow(id);
    }

    public void updateScreen(Screens s) {
        screenDAO.update(s.getId(),s);
    }
}
