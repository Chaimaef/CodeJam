package com.example.CodeJam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import com.example.CodeJam.H2jdbc;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeJamApplication {
	
	  static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:file:/Users/chaimaefahmi/Downloads/CodeJam/src/main/resources/data.sql";  
	   
	   //  Database credentials 
	   static final String USER = "sa"; 
	   static final String PASS = ""; 

	public static void main(String[] args) {
		SpringApplication.run(CodeJamApplication.class, args);
		
		
		  Connection conn = null; 
	      Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER); 
	             
	         //STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         
	         //To insert in the database
//	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement(); 
//	         String sql =  "CREATE TABLE   REGISTRATION " + 
//	            "(id INTEGER not NULL, " + 
//	            " first VARCHAR(255), " +  
//	            " last VARCHAR(255), " +  
//	            " age INTEGER, " +  
//	            " PRIMARY KEY ( id ))";  
//	         stmt.executeUpdate(sql);
//	         System.out.println("Created table in given database...");
//	         String sql = "INSERT INTO Registration (ID, FIRST, LAST, AGE) VALUES (6, 'Chaimae', 'Fahmi', 21)";
	         
	         
	         
	         // To retrieve from the database
	         String sql = "SELECT *  FROM Registration";
	         ResultSet res = stmt.executeQuery(sql);
	         while (res.next())
	         {
	           int id = res.getInt("id");
	           String firstName = res.getString("first");
	           String lastName = res.getString("last");
	           String age = res.getString("age");
	           System.out.format("%s, %s, %s, %s\n", id, firstName, lastName, age);
	         }
	         // STEP 4: Clean-up environment 
	         stmt.close(); 
	         conn.close(); 
	      } catch(SQLException se) { 
	         //Handle errors for JDBC 
	         se.printStackTrace(); 
	      } catch(Exception e) { 
	         //Handle errors for Class.forName 
	         e.printStackTrace(); 
	      } finally { 
	         //finally block used to close resources 
	         try{ 
	            if(stmt!=null) stmt.close(); 
	         } catch(SQLException se2) { 
	         } // nothing we can do 
	         try { 
	            if(conn!=null) conn.close(); 
	         } catch(SQLException se){ 
	            se.printStackTrace(); 
	         } //end finally try 
	      } //end try 
	      System.out.println("Goodbye!");
	}

}
