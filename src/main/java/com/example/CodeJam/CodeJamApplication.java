package com.example.CodeJam;

import com.example.CodeJam.DiagnosisApi.SymptomsList;
import com.example.CodeJam.FindDoctorApi.FindDoctor;
import com.example.CodeJam.models.diagnosis.Symptom;
import com.example.CodeJam.models.findDoctor.Doctor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.print.Doc;
import java.util.List;

@SpringBootApplication
public class CodeJamApplication {
	
//	  static final String JDBC_DRIVER = "org.h2.Driver";
//	   static final String DB_URL = "jdbc:h2:file:/Users/chaimaefahmi/Downloads/CodeJam/src/main/resources/data.sql";
//
//	   //  Database credentials
//	   static final String USER = "sa";
//	   static final String PASS = "";

	public static void main(String[] args) {
		SpringApplication.run(CodeJamApplication.class, args);

		//List<Symptom> symptoms = SymptomsList.getSymptomsList();
		FindDoctor fd = new FindDoctor();
//		List<Doctor> doctors = fd.getDoctors("pediatrician", "ca-berkeley");
//		System.out.println(doctors.get(0).getClinicName());
//		System.out.println(doctors.get(0).getPhone());
//		System.out.println(doctors.get(0).getStreet());
	}
	
	@Bean
	@SuppressWarnings("deprecation")
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurerAdapter() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	        	
	        	registry.addMapping("/**");
	        }
	    };
	}

}
