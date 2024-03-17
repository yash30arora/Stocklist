package com.cognizant.Authentication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class UserAuth {
@Id
	    private String email;
	    private String password;
	    
	    public UserAuth(String email, String password) {
	        this.email = email;
	        this.password = password;
	    }

	    public UserAuth() {
	    }
	    

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
}



