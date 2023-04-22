package com.neu.edu.moviebookingsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Role {

    @JsonProperty("user")
    USER,
    @JsonProperty("role")
    ADMIN
}
