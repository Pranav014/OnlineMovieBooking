package com.neu.edu.moviebookingsystem.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Shows {


    @Basic
    @Column(name = "price")
    private long price;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "time")
    private Time time;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "showID")
    private long showId;
    @OneToMany(mappedBy = "showsByShowId", fetch = FetchType.EAGER)
    private Collection<Screens> screensByShowId;
    @ManyToOne
    @JoinColumn(name = "movieID", referencedColumnName = "id", nullable = false)
    private Movie movieByMovieId;
    @ManyToOne
    @JoinColumn(name = "TheatreID", referencedColumnName = "id", nullable = false)
    private Theatre theatreByTheatreId;



    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shows shows = (Shows) o;
        return movieByMovieId.getId() == shows.getMovieByMovieId().getId() && theatreByTheatreId.getId() == shows.getTheatreByTheatreId().getId() && price == shows.price && showId == shows.showId && Objects.equals(date, shows.date) && Objects.equals(time, shows.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieByMovieId.getId(), theatreByTheatreId.getShowsById(), price, date, time, showId);
    }

    public Collection<Screens> getScreensByShowId() {
        return screensByShowId;
    }

    public void setScreensByShowId(Collection<Screens> screensByShowId) {
        this.screensByShowId = screensByShowId;
    }

    public Movie getMovieByMovieId() {
        return movieByMovieId;
    }

    public void setMovieByMovieId(Movie movieByMovieId) {
        this.movieByMovieId = movieByMovieId;
    }

    public Theatre getTheatreByTheatreId() {
        return theatreByTheatreId;
    }

    public void setTheatreByTheatreId(Theatre theatreByTheatreId) {
        this.theatreByTheatreId = theatreByTheatreId;
    }
}
