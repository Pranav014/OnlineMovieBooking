package com.neu.edu.moviebookingsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
public class Shows {
    //TODO shows in a theatre

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;
    private int price;
    private Date date;
    private Time time;
    @Id
    @GeneratedValue
    private Long showId;

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getShowId() {
        return showId;
    }


}
