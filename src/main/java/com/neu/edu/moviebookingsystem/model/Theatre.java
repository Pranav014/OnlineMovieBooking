package com.neu.edu.moviebookingsystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "theatre")
public class Theatre {
    private String theatreName;
    private String theatreLocation;


    @Id
    @GeneratedValue
    private Long theatreId;

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    @Id
    @GeneratedValue
    public Long getTheatreId() {
        return theatreId;
    }
}
