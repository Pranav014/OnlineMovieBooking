package com.neu.edu.moviebookingsystem.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Movie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "movieName")
    private String movieName;
    @Basic
    @Column(name = "releaseDate")
    private Date releaseDate;
    @Basic
    @Column(name = "theatreoutdate")
    private Date theatreoutdate;
    @Basic
    @Column(name = "leadActor")
    private String leadActor;
    @Basic
    @Column(name = "leadActress")
    private String leadActress;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "runtime")
    private Time runtime;
    @OneToMany(mappedBy = "movieByMovieId")
    private Collection<Shows> showsById;

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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getTheatreoutdate() {
        return theatreoutdate;
    }

    public void setTheatreoutdate(Date theatreoutdate) {
        this.theatreoutdate = theatreoutdate;
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

    public void setLeadActress(String leadActress) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && Objects.equals(movieName, movie.movieName) && Objects.equals(releaseDate, movie.releaseDate) && Objects.equals(theatreoutdate, movie.theatreoutdate) && Objects.equals(leadActor, movie.leadActor) && Objects.equals(leadActress, movie.leadActress) && Objects.equals(description, movie.description) && Objects.equals(runtime, movie.runtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieName, releaseDate, theatreoutdate, leadActor, leadActress, description, runtime);
    }

    public Collection<Shows> getShowsById() {
        return showsById;
    }

    public void setShowsById(Collection<Shows> showsById) {
        this.showsById = showsById;
    }
}
