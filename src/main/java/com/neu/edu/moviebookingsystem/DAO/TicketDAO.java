package com.neu.edu.moviebookingsystem.DAO;

import com.neu.edu.moviebookingsystem.Entities.Ticket;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Component
@Configurable
public class TicketDAO extends Dao{

    public boolean addTicket(Ticket ticket){
        try {
            begin();
            getSession().save(ticket);
            commit();
            close();
            return true;

        } catch (Exception e) {
            throw new RuntimeException("Error while add ticket to database " + e.getMessage() + " line number " + e.getStackTrace());
        }
    }

}
