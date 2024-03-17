package com.cognizant.UserProfile.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.UserProfile.Exception.UserAlreadyExistException;
import com.cognizant.UserProfile.Exception.UserNotFoundException;
import com.cognizant.UserProfile.Model.User;
import com.cognizant.UserProfile.Service.UserService;


@RequestMapping("/ProfitPilot")
@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	 @Autowired
	    UserService userService;
	    //get user by id
	    @GetMapping("/GetUserById/{userId}")
	    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId){
	        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
	    }
	    
	   
	    
    
	    @GetMapping("/getProfile/{email}")
		public ResponseEntity<Object> getUserProfileByEmail(@PathVariable String email) {
			return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
		}
	     
   
	  
	    //add user
	    @PostMapping("/addUser")
	    public ResponseEntity<?> addUser(@RequestBody User user) {
	        try{
	            User addedUser = userService.addUser(user);
	            return new ResponseEntity<>(addedUser, HttpStatus.OK);
	        }catch (UserAlreadyExistException e){
	            return new ResponseEntity<>("user already exist",HttpStatus.CONFLICT);
	        }
	    }
	    //update existing user
	    @PutMapping("/updateUser/{userId}")
	    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("userId") Long userId) {
	        try{
	            User updatedUser = userService.updateUser(user,userId);
	            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	        }
	        catch (UserNotFoundException e){
	            return new ResponseEntity<>("user not found",HttpStatus.CONFLICT);
	        }
	              
	    }
	    @DeleteMapping("/deleteUser/{id}")
		public ResponseEntity<String> deleteUser(@PathVariable long id)
		{
			return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
		}
	}


