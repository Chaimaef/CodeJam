package com.example.CodeJam.DiagnosisApi;

import com.example.CodeJam.Utilities.Utils;
import com.example.CodeJam.models.diagnosis.Symptom;
import com.example.CodeJam.models.diagnosis.Verdict;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VerdictGiver {
    RestTemplate restTemplate;
    String baseUrl;

    public VerdictGiver() {
        this.restTemplate = new RestTemplate();
        this.baseUrl = "https://sandbox-healthservice.priaid.ch/";
    }

    public List<Verdict> giveVerdict(List<String> symptoms) {

        List<Symptom> symptomList = SymptomsList.getSymptomsList();
        List<Integer> ids = new ArrayList<>();

        for (String s : symptoms) {
            for (Symptom symptom: symptomList) {
                if (s.equals(symptom.getName())) {
                    ids.add(symptom.getID());
                }
            }
        }

        String idString = "[";
        for (int i = 0; i < ids.size()-1; i++) {
            idString += ids.get(i).toString();
            idString += ", ";
        }
        idString += ids.get(ids.size()-1).toString() + "]";

        System.out.println(idString);

        ResponseEntity<List<Verdict>> response =
                restTemplate.exchange(baseUrl + "diagnosis?symptoms=" + idString + "&gender=male&year_of_birth=30&token=" +
                                Utils.diagnosisKey + "&format=json&language=en-gb",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Verdict>>() {
                        });
        List<Verdict> verdicts = response.getBody();
        for (Verdict v : verdicts) {
            getDescription(v);
            System.out.println(v.getDescription());
        }

        return verdicts;
    }

    public void getDescription(Verdict verdict) {
        ResponseEntity<HashMap> response = restTemplate.getForEntity(baseUrl + "issues/" + verdict.getIssue().get("ID")
                + "/info?token=" + Utils.diagnosisKey + "&format=json&language=en-gb", HashMap.class);
        HashMap<String, Object> map = response.getBody();
        verdict.setDescription((String) map.get("Description"));
    }
}
