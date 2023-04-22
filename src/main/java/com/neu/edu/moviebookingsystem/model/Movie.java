package com.neu.edu.moviebookingsystem.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Movie")
public class Movie {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String movieName;
    private Date releaseDate;
    private Date outDate;
    private String leadActor;
    private String leadActress;
    private String description;
    private Time runtime;
    @OneToMany(mappedBy = "movie")
    private Set<Shows> shows;



    public Movie() {
    }


    public Movie(String movieName, Date releaseDate, Date outDate, String leadActor, String leadActress, String description, Time runtime, Set<Shows> shows) {
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.outDate = outDate;
        this.leadActor = leadActor;
        this.leadActress = leadActress;
        this.description = description;
        this.runtime = runtime;
        this.shows = shows;
    }

    public Long getId() {
        return Id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public String getLeadActress() {
        return leadActress;
    }

    public void setLedActress(String leadActress) {
        this.leadActress = leadActress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getRuntime() {
        return runtime;
    }

    public void setRuntime(Time runtime) {
        this.runtime = runtime;
    }

    public List<Shows> getShows(){
        // TODO returns all the shows of a particular movie
        return null;
    }

}
