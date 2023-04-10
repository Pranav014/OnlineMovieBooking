package com.neu.edu.moviebookingsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;
import java.sql.Time;

public class Ticket {
    private Long ticketID;
    private String movieName;
    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User user;
    private Date dateOfshow;
    private Time timeOfShow;
    private int price;
    private int quantity;
    private int seats;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_Id", referencedColumnName = "Id")
    private Movie movie;

}
