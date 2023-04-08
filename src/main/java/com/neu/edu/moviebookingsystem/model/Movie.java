package com.neu.edu.moviebookingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "Movie")
public class Movie {
    @javax.persistence.Id
    @GeneratedValue
    private Long Id;
    private String movieName;
    private Date releaseDate;
    private Date outDate;
    private String leadActor;
    private String leadActress;
    private String description;
    private Time runtime;

    public Movie() {
    }

    public Movie(String movieName, Date releaseDate, Date outDate, String leadActor, String leadActress, String description, Time runtime) {
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.outDate = outDate;
        this.leadActor = leadActor;
        this.leadActress = leadActress;
        this.description = description;
        this.runtime = runtime;
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
}
