package com.example.CodeJam.controllers;

import com.example.CodeJam.DiagnosisApi.SymptomsList;
import com.example.CodeJam.FindDoctorApi.FindDoctor;
import com.example.CodeJam.models.diagnosis.Symptom;
import com.example.CodeJam.models.findDoctor.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorsController {
    @GetMapping(path = "/doctors/{spec}/{city}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Doctor>> getDoctors(@PathVariable String spec, @PathVariable String city) {
        FindDoctor fd = new FindDoctor();
        return new ResponseEntity<List<Doctor>>(fd.getDoctors(spec, city), null, HttpStatus.OK);
    }
}
