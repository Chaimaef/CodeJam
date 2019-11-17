package com.example.CodeJam.models.diagnosis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {
    private int id;
    private String name;
    private String accuracy;

}
