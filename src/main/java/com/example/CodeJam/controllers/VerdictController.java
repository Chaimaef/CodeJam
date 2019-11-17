package com.example.CodeJam.controllers;

import com.example.CodeJam.DiagnosisApi.VerdictGiver;
import com.example.CodeJam.models.diagnosis.Verdict;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VerdictController {
    @PostMapping(path = "/verdicts", consumes = "application/json", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Verdict>> getVerdicts(@RequestBody List<String> symptoms) {
        VerdictGiver vg = new VerdictGiver();
        return new ResponseEntity<List<Verdict>>(vg.giveVerdict(symptoms), null, HttpStatus.OK);
    }
}
