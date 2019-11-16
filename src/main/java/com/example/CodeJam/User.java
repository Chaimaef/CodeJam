package com.example.CodeJam;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Persons")
public class User {

	 private String id;
	 private String firstName;
	 private String lastName;
	 private String city;
	 private String address;
	 
	 
	 public User(String id, String firstName, String lastName, String city, String address) {
		 this.id = id;
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.city = city;
		 this.address = address;
		
	 }
}
