package com.cognizant.UserProfile.Service;

import java.util.Optional;

import com.cognizant.UserProfile.Exception.UserAlreadyExistException;
import com.cognizant.UserProfile.Exception.UserNotFoundException;
import com.cognizant.UserProfile.Model.User;

public interface UserService {
	
	 User getUserById(Long userId);
	    User addUser(User user) throws UserAlreadyExistException;
	    User updateUser(User updatedUser, Long userId) throws UserNotFoundException;
	  String deleteUser(long id);
	// User getUserByEmail(String email);
	  public Optional<User> getUserByEmail(String email);
}


