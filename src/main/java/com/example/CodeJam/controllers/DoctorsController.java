package com.example.CodeJam.controllers;

import com.example.CodeJam.FindDoctorApi.FindDoctor;
import com.example.CodeJam.models.findDoctor.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorsController {
    @GetMapping(path = "/doctors/{spec}/{city}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Doctor>> getDoctors(@PathVariable String spec, @PathVariable String city) {
        switch (spec) {
            case "General practice":
                spec = "general-practitioner";
                break;
            case "Dermatology":
                spec = "dermatologist";
                break;
            case "Psychiatry":
                spec = "psychiatrist";
                break;
            case "Gynecology":
                spec = "gynecologist";
                break;
            case "Neurology":
                spec = "neurologist";
                break;
            case "Cardiology":
                spec = "cardiologist";
                break;
            case "Internal medicine":
                spec = "internist";
                break;
            case "Gastroenterology":
                spec = "gastroenterologist";
                break;
            case "Urology":
                spec = "urologist";
                break;
            case "Surgery":
                spec = "general-surgeon";
                break;
            case "Orthopedics":
                spec = "orthopedic-surgeon";
                break;
            case "Rheumatology":
                spec = "rheumatologist";
                break;
            case "Allergology":
                spec = "allergist";
                break;
            case "Otolaryngology":
                spec = "ear-nose-throat-doctor";
                break;
            case "Pulmonology":
                spec = "pulmonologist";
                break;
        }

        FindDoctor fd = new FindDoctor();
        return new ResponseEntity<List<Doctor>>(fd.getDoctors(spec, city), null, HttpStatus.OK);
    }
}
