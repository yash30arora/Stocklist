
package com.cognizant.Authentication.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Authentication.Configuration.JwtTokenGen;
import com.cognizant.Authentication.Exception.UserNotFoundException;
import com.cognizant.Authentication.Model.UserAuth;
import com.cognizant.Authentication.Service.ServiceAuth;



@RestController
@CrossOrigin(origins = "*")
public class ControllerAuthentication {
	 @Autowired
	    ServiceAuth authService;
	    @PostMapping("/login")
	    public ResponseEntity<?> loginUser(@RequestBody UserAuth userAuth){
	        try{
	            if (userAuth.getEmail() == null || userAuth.getPassword() == null) {
	                throw new UserNotFoundException("email and password are null");
	            }
	            boolean result=authService.getAuthenticUser(userAuth.getEmail(), userAuth.getPassword());
	            if(result)
	            {
	                Map<String, String> token= new JwtTokenGen().generateToken(userAuth);
	                
	                return new ResponseEntity<Map>(token,HttpStatus.OK);
	            }else if (result == false) {
	                throw new UserNotFoundException("Email / password mismatch");
	            }
	        }
	        catch (UserNotFoundException e){
	            System.out.println(e.getMessage());
	            return new ResponseEntity("Invalid user",HttpStatus.UNAUTHORIZED);
	        }
	        return null;
	    }
	    
}