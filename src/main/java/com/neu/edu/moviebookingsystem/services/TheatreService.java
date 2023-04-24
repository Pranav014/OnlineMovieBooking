package com.neu.edu.moviebookingsystem.services;

import com.neu.edu.moviebookingsystem.Entities.Theatre;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Configurable
public class TheatreService implements IService<Theatre>{

    @Override
    public boolean save(Theatre theatre) {

        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Theatre> getData() {
        return null;
    }

    @Override
    public Theatre update(long id, Theatre theatre) {
        return null;
    }

    @Override
    public Theatre find(long id) {
        return null;
    }
}
