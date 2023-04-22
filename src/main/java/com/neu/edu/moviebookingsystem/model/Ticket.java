package com.neu.edu.moviebookingsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue
    private Long ticketID;
    private String movieName;
    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User user;
    private Date dateOfshow;
    private Time timeOfShow;
    private int price;
    private int quantity;
    private int numberOfSeats;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_Id", referencedColumnName = "Id")
    private Movie movie;

    public boolean cancelBooking(){
        return false;
    }
}
