package com.neu.edu.moviebookingsystem.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Ticket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "MovieName")
    private String movieName;
    @Basic
    @Column(name = "dateOfMovie")
    private Date dateOfMovie;
    @Basic
    @Column(name = "MovieTime")
    private Time movieTime;
    @Basic
    @Column(name = "price")
    private long price;
    @Basic
    @Column(name = "quantity")
    private long quantity;
    @Basic
    @Column(name = "seats")
    private String seats;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User userByUserId;
    @ManyToOne
    @JoinColumn(name = "screen_Id", referencedColumnName = "id", nullable = false)
    private Screens screensByScreenId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }



    public Date getDateOfMovie() {
        return dateOfMovie;
    }

    public void setDateOfMovie(Date dateOfMovie) {
        this.dateOfMovie = dateOfMovie;
    }

    public Time getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(Time movieTime) {
        this.movieTime = movieTime;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && userByUserId.getId() == ticket.userByUserId.getId() && price == ticket.price
                && quantity == ticket.quantity && screensByScreenId.getId() == ticket.getScreensByScreenId().getId()
                && Objects.equals(movieName, ticket.movieName) && Objects.equals(dateOfMovie, ticket.dateOfMovie)
                && Objects.equals(movieTime, ticket.movieTime) && Objects.equals(seats, ticket.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieName, userByUserId.getId(), dateOfMovie, movieTime, price, quantity, seats, screensByScreenId.getId());
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Screens getScreensByScreenId() {
        return screensByScreenId;
    }

    public void setScreensByScreenId(Screens screensByScreenId) {
        this.screensByScreenId = screensByScreenId;
    }
}
