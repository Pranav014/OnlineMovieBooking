package com.neu.edu.moviebookingsystem.services;

import com.neu.edu.moviebookingsystem.DAO.TicketDAO;
import com.neu.edu.moviebookingsystem.Entities.Ticket;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class TicketService {


    final TicketDAO ticketDAO;

    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public boolean addTicket(Ticket ticket){
        return ticketDAO.addTicket(ticket);

    }

}
