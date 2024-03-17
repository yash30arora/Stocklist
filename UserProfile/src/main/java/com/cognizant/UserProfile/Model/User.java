package com.cognizant.UserProfile.Model;

import org.hibernate.validator.constraints.Email;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
@Entity
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private Long userid;
	    @NotBlank(message="name is mandotory")
	    private String name;
	    @NotBlank(message="password is mandotory")
	    private String password;
	    @NotBlank(message="email is mandotory")
	    private String email;
	    @NotBlank(message="country is mandotory")
	    private String country;
	    public User(Long userid, String name, String password, String email, String country) {
	        this.userid = userid;
	        this.name = name;
	        this.password = password;
	        this.email = email;
	        this.country = country;
	    }
	    public User(){}

	    public Long getUserid() {
	        return userid;
	    }

	    public void setUserid(Long userid) {
	        this.userid = userid;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getCountry() {
	        return country;
	    }

	    public void setCountry(String country) {
	        this.country = country;
	    }
		public void setId(Long userId2) {
			// TODO Auto-generated method stub
			
		}


	}
