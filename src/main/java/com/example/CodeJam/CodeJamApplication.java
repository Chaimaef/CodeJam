package com.example.CodeJam;

import com.example.CodeJam.DiagnosisApi.SymptomsList;
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
	
//	  static final String JDBC_DRIVER = "org.h2.Driver";
//	   static final String DB_URL = "jdbc:h2:file:/Users/chaimaefahmi/Downloads/CodeJam/src/main/resources/data.sql";
//
//	   //  Database credentials
//	   static final String USER = "sa";
//	   static final String PASS = "";

	public static void main(String[] args) {
		SpringApplication.run(CodeJamApplication.class, args);

		List<Symptom> symptoms = SymptomsList.getSymptomsList();
//		for (Symptom s: symptoms) {
//			System.out.println(s.getName());
//		}

//		  Connection conn = null;
//	      Statement stmt = null;
//	      try {
//	         // STEP 1: Register JDBC driver
//	         Class.forName(JDBC_DRIVER);
//
//	         //STEP 2: Open a connection
//	         System.out.println("Connecting to database...");
//	         conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//
//	         //To insert in the database
////	         System.out.println("Creating table in given database...");
//	         stmt = conn.createStatement();
////	         String sql =  "CREATE TABLE   REGISTRATION " +
////	            "(id INTEGER not NULL, " +
////	            " first VARCHAR(255), " +
////	            " last VARCHAR(255), " +
////	            " age INTEGER, " +
////	            " PRIMARY KEY ( id ))";
////	         stmt.executeUpdate(sql);
////	         System.out.println("Created table in given database...");
////	         String sql = "INSERT INTO Registration (ID, FIRST, LAST, AGE) VALUES (6, 'Chaimae', 'Fahmi', 21)";
//
//
//
//	         // To retrieve from the database
//	         String sql = "SELECT *  FROM Registration";
//	         ResultSet res = stmt.executeQuery(sql);
//	         while (res.next())
//	         {
//	           int id = res.getInt("id");
//	           String firstName = res.getString("first");
//	           String lastName = res.getString("last");
//	           String age = res.getString("age");
//	           System.out.format("%s, %s, %s, %s\n", id, firstName, lastName, age);
//	         }
//	         // STEP 4: Clean-up environment
//	         stmt.close();
//	         conn.close();
//	      } catch(SQLException se) {
//	         //Handle errors for JDBC
//	         se.printStackTrace();
//	      } catch(Exception e) {
//	         //Handle errors for Class.forName
//	         e.printStackTrace();
//	      } finally {
//	         //finally block used to close resources
//	         try{
//	            if(stmt!=null) stmt.close();
//	         } catch(SQLException se2) {
//	         } // nothing we can do
//	         try {
//	            if(conn!=null) conn.close();
//	         } catch(SQLException se){
//	            se.printStackTrace();
//	         } //end finally try
//	      } //end try
//	      System.out.println("Goodbye!");
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
