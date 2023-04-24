package com.neu.edu.moviebookingsystem.services;

import com.neu.edu.moviebookingsystem.Entities.Screens;
import com.neu.edu.moviebookingsystem.Entities.Shows;
import com.neu.edu.moviebookingsystem.Entities.Ticket;
import com.neu.edu.moviebookingsystem.Entities.User;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@Configurable
public class BookingService {


    final ShowService showService;


    final ScreenService screenService;


    final TicketService ticketService;


    public BookingService(ShowService showService, ScreenService screenService, TicketService ticketService) {
        this.showService = showService;
        this.screenService = screenService;
        this.ticketService = ticketService;
    }

    public Ticket bookTicket(long show_id, List<String> checkboxes){
        //TODO Calculate price , check contraints, if all true change in database
        Date today = Date.valueOf(LocalDate.now());

        Shows show = showService.getShow(show_id);
        System.out.println(" SCREENBYSHOWID ");
        System.out.println(show.getScreensByShowId());
        // ===================== DUMMY USER FOR NOW
        User u = new User();
        // =========================================
        Screens screen = new Screens();
        for (Screens s : show.getScreensByShowId()){
            for (String str : checkboxes){
                String seat = str.substring(0, 2);
                int screenNumber = Integer.parseInt(str.substring(str.length()-1,str.length()));
                if (s.getSeatNumber().equals(seat)){
                    byte b = 1;
                    s.setSeatStatus(b);
                    screen.setScreenNumber(screenNumber);
                    screen.setId(s.getId());
                    screen.setSeatStatus(s.getSeatStatus());

                    screenService.updateScreen(s);
                }
            }
            // Set session user
//            s.setUserByBookedbyUser();
        }
        showService.updateShow(show);
        u.setId(1l);
        Ticket ticket = new Ticket();
        ticket.setDateOfMovie(show.getDate());
        ticket.setMovieName(show.getMovieByMovieId().getMovieName());
        ticket.setUserByUserId(u);
        long price = show.getPrice() * checkboxes.size();  // * number of seats from screen
        ticket.setPrice(price);
        ticket.setQuantity(checkboxes.size());
        ticket.setMovieTime(show.getTime());
        ticket.setSeats(checkboxes.toString());
        ticket.setScreensByScreenId(screen);
        if (!ticketService.addTicket(ticket)){
            return null;
        }

        return ticket;
    }



}
