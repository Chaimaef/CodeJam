package com.example.CodeJam;

import com.example.CodeJam.DiagnosisApi.SymptomsList;
import com.example.CodeJam.FindDoctorApi.FindDoctor;
import com.example.CodeJam.models.diagnosis.Symptom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
public class CodeJamApplication {


	public static void main(String[] args) {
		SpringApplication.run(CodeJamApplication.class, args);
		SymptomsList.getSymptomsList();
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
