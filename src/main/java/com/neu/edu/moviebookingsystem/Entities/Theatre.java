package com.neu.edu.moviebookingsystem.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Theatre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "TheatreName")
    private String theatreName;
    @Basic
    @Column(name = "TheatreLocation")
    private String theatreLocation;
    @OneToMany(mappedBy = "theatreByTheatreId")
    private Collection<Shows> showsById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreLocation() {
        return theatreLocation;
    }

    public void setTheatreLocation(String theatreLocation) {
        this.theatreLocation = theatreLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theatre theatre = (Theatre) o;
        return id == theatre.id && Objects.equals(theatreName, theatre.theatreName) && Objects.equals(theatreLocation, theatre.theatreLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, theatreName, theatreLocation);
    }

    public Collection<Shows> getShowsById() {
        return showsById;
    }

    public void setShowsById(Collection<Shows> showsById) {
        this.showsById = showsById;
    }
}
