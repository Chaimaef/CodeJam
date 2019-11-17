package com.example.CodeJam.controllers;

import com.example.CodeJam.DiagnosisApi.VerdictGiver;
import com.example.CodeJam.models.diagnosis.Verdict;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
//public class VerdictController {
//    @PostMapping(path = "/verdicts", consumes = "application/json", produces = { MediaType.APPLICATION_JSON_VALUE })
//    public ResponseEntity<List<Verdict>> getVerdicts(@RequestBody List<String> symptoms) {
//        VerdictGiver vg = new VerdictGiver();
//        return new ResponseEntity<List<Verdict>>(vg.giveVerdict(symptoms), null, HttpStatus.OK);
//    }

public class VerdictController {
	@PostMapping(path = "/verdicts", consumes = "application/json", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<String>> getVerdicts(@RequestBody List<String> symptoms) {
		VerdictGiver vg = new VerdictGiver();
		List <Verdict> verdicts = vg.giveVerdict(symptoms);
		List<String> test = new ArrayList<>();
		for(Verdict v : verdicts) {
			String description = v.getDescription();
			List<HashMap<String, Object>> specialisations = v.getSpecialisations();
			for (HashMap<String, Object> s :specialisations ) {
				test.add((String) s.get("Name"));
			}
			test.add(description);
		}

		return new ResponseEntity<List<String>>(test, null, HttpStatus.OK);
	}

	//    @PostMapping(path = "/verdicts", consumes = "application/json", produces = { MediaType.APPLICATION_JSON_VALUE })
	//    public ResponseEntity<List<String>> getVerdicts(@RequestBody List<String> symptoms) {
	//        //VerdictGiver vg = new VerdictGiver();
	//    	List<String> test = new ArrayList<>();
	//    	test.add("Test1");
	//    	test.add("Test2");
	//        return new ResponseEntity<List<String>>(test, null, HttpStatus.OK);
	//    }
}
