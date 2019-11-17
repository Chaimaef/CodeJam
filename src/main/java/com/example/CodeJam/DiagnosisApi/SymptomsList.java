package com.example.CodeJam.DiagnosisApi;

import com.example.CodeJam.Utilities.Utils;
import com.example.CodeJam.models.diagnosis.Symptom;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SymptomsList {
    private static List<Symptom> symptoms = null;

    private SymptomsList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://sandbox-healthservice.priaid.ch/symptoms?token=" + Utils.diagnosisKey + "&format=json&language=en-gb";

        ResponseEntity<List<Symptom>> response =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Symptom>>() {
                        });
        symptoms = response.getBody();

    }

    public static List<Symptom> getSymptomsList() {
        if (symptoms == null) {
            new SymptomsList();
        }
        return symptoms;
    }
}
