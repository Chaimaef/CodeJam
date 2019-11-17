package com.example.CodeJam.models.diagnosis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Verdict {
    private HashMap<String, Object> issue;
    private List<HashMap<String, Object>> specialisations;
    private String description;

    @JsonProperty("Issue")
    public HashMap<String, Object> getIssue() {
        return issue;
    }

    public void setIssue(HashMap<String, Object> issue) {
        this.issue = issue;
    }

    @JsonProperty("Specialisation")
    public List<HashMap<String, Object>> getSpecialisations() {
        return specialisations;
    }

    public void setSpecialisations(List<HashMap<String, Object>> specialisations) {
        this.specialisations = specialisations;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
