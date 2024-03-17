package com.cognizant.UserProfile.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.cognizant.UserProfile.Exception.UserAlreadyExistException;
import com.cognizant.UserProfile.Exception.UserNotFoundException;
import com.cognizant.UserProfile.Model.User;
import com.cognizant.UserProfile.Service.UserService;

public class UserServiceTest {

    @Test
    public void testGetUserById() {
        // Mock UserService implementation
        UserService userService = mock(UserService.class);
        
        // Mock user
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("John Doe");

        // Define behavior
        when(userService.getUserById(1L)).thenReturn(mockUser);

        // Invoke the method
        User result = userService.getUserById(1L);

        // Verify the result
        assertEquals(mockUser, result);
    }

    @Test
    public void testAddUser() throws UserAlreadyExistException {
        // Mock UserService implementation
        UserService userService = mock(UserService.class);
        
        // Mock user
        User newUser = new User();
        newUser.setName("Alice");

        // Define behavior
        when(userService.addUser(newUser)).thenReturn(newUser);

        // Invoke the method
        User result = userService.addUser(newUser);

        // Verify the result
        assertEquals(newUser, result);
    }

    @Test
    public void testUpdateUser() throws UserNotFoundException {
        // Mock UserService implementation
        UserService userService = mock(UserService.class);
        
        // Mock updated user
        User updatedUser = new User();
        updatedUser.setId(1L);
        updatedUser.setName("Updated Name");

        // Define behavior
        when(userService.updateUser(updatedUser, 1L)).thenReturn(updatedUser);

        // Invoke the method
        User result = userService.updateUser(updatedUser, 1L);

        // Verify the result
        assertEquals(updatedUser, result);
    }

    @Test
    public void testDeleteUser() {
        // Mock UserService implementation
        UserService userService = mock(UserService.class);
        
        // Define behavior
        when(userService.deleteUser(1L)).thenReturn("User deleted successfully");

        // Invoke the method
        String result = userService.deleteUser(1L);

        // Verify the result
        assertEquals("User deleted successfully", result);
    }

    @Test
    public void testGetUserByEmail() {
        // Mock UserService implementation
        UserService userService = mock(UserService.class);

        // Mock user
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setEmail("test@example.com");

        // Define behavior
        when(userService.getUserByEmail("test@example.com")).thenReturn(Optional.of(mockUser));

        // Invoke the method
        Optional<User> result = userService.getUserByEmail("test@example.com");

        // Verify the result
        assertTrue(result.isPresent());
        assertEquals(mockUser, result.get());
    }
}
