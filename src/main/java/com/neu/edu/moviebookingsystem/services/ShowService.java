package com.neu.edu.moviebookingsystem.services;

import com.neu.edu.moviebookingsystem.DAO.ShowDAO;
import com.neu.edu.moviebookingsystem.Entities.Shows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class ShowService {

    final ShowDAO showDAO;

    @Autowired
    public ShowService(ShowDAO showDAO) {
        this.showDAO = showDAO;
    }

    public List<Shows> getShows(){
        return showDAO.getShows();
    }

    public Shows getShow(long show_id) {
        return showDAO.getAShow(show_id);
    }

    public void updateShow(Shows show) {
        showDAO.updateShow(show);
    }
}
