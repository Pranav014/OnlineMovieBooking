package com.neu.edu.moviebookingsystem.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Screens {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "ScreenNumber")
    private long screenNumber;
    @Basic
    @Column(name = "SeatNumber")
    private String seatNumber;
    @Basic
    @Column(name = "seatStatus")
    private byte seatStatus;


    @ManyToOne
    @JoinColumn(name = "showId", referencedColumnName = "showID", nullable = false)
    private Shows showsByShowId;
    @ManyToOne
    @JoinColumn(name = "bookedbyUser", referencedColumnName = "id", nullable = false)
    private User userByBookedbyUser;
    @OneToMany(mappedBy = "screensByScreenId")
    private Collection<Ticket> ticketsById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(long screenNumber) {
        this.screenNumber = screenNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public byte getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(byte seatStatus) {
        this.seatStatus = seatStatus;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screens screens = (Screens) o;
        return id == screens.id && screenNumber == screens.screenNumber && seatStatus == screens.seatStatus && getShowsByShowId().getShowId() == screens.getShowsByShowId().getShowId() && userByBookedbyUser.getId() == screens.userByBookedbyUser.getId() && Objects.equals(seatNumber, screens.seatNumber);
    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, screenNumber, seatNumber, seatStatus, getShowsByShowId().getShowId(), userByBookedbyUser.getId());
//    }

    public Shows getShowsByShowId() {
        return showsByShowId;
    }

    public void setShowsByShowId(Shows showsByShowId) {
        this.showsByShowId = showsByShowId;
    }

    public User getUserByBookedbyUser() {
        return userByBookedbyUser;
    }

    public void setUserByBookedbyUser(User userByBookedbyUser) {
        this.userByBookedbyUser = userByBookedbyUser;
    }

    public Collection<Ticket> getTicketsById() {
        return ticketsById;
    }

    public void setTicketsById(Collection<Ticket> ticketsById) {
        this.ticketsById = ticketsById;
    }
}
