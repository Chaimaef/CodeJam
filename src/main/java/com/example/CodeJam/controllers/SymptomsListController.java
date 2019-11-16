package com.example.CodeJam.controllers;

import com.example.CodeJam.DiagnosisApi.SymptomsList;
import com.example.CodeJam.models.diagnosis.Symptom;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SymptomsListController {

    @GetMapping(path = "/symptoms", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Symptom>> Hello() {
        return new ResponseEntity<List<Symptom>>(SymptomsList.getSymptomsList(), null, HttpStatus.OK);
    }
}
