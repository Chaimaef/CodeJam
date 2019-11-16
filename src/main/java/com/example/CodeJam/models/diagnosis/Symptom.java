package com.example.CodeJam.models.diagnosis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Symptom implements Serializable {
    private int id;
    private String name;

    @JsonProperty("ID")
    public int getID() {
        return id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }
}
