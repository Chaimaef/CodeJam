package com.example.CodeJam.FindDoctorApi;

import com.example.CodeJam.models.findDoctor.Doctor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDoctor {
    private String key;
    private String baseUrl;
    RestTemplate restTemplate;

    public FindDoctor() {
        this.key = "5314256ecd19ac736d3b4726df628a05";
        this.baseUrl = "https://api.betterdoctor.com/2016-03-01";
        this.restTemplate = new RestTemplate();
    }

    public ArrayList<Doctor> getDoctors(String speciality, String city) {
        ArrayList<Doctor> doctors = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        String url
                = "https://api.betterdoctor.com/2016-03-01/doctors?specialty_uid=" + speciality + "&location=" + city + "&user_key="+key;
        ResponseEntity<HashMap> response = restTemplate.getForEntity(url, HashMap.class);
        HashMap<String, Object> map = response.getBody();
        List<HashMap<String, Object>> data = (List<HashMap<String, Object>>) map.get("data");
        for (int i = 0; i<data.size(); i++) {
            HashMap<String, Object> subData = data.get(i);
            List<HashMap<String, Object>> practices = (List<HashMap<String, Object>>) subData.get("practices");

            for (int j = 0; j<practices.size(); j++) {
                HashMap<String, Object> subPractices = practices.get(j);
                Doctor doctor = new Doctor();
                doctor.setClinicName((String) subPractices.get("name"));

                HashMap<String, Object> visitAddress = (HashMap<String, Object>) subPractices.get("visit_address");
                doctor.setStreet((String) visitAddress.get("street"));

                List<HashMap<String, Object>> phones = (List<HashMap<String, Object>>) subPractices.get("phones");
                doctor.setPhone((String) phones.get(0).get("number"));

                doctors.add(doctor);
            }
        }

        return doctors;
    }
}
