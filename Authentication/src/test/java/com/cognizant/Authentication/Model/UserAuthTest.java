package com.cognizant.Authentication.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognizant.Authentication.Model.UserAuth;

public class UserAuthTest {

    @Test
    public void testGetterAndSetterMethods() {
        // Create a UserAuth instance
        UserAuth user = new UserAuth();
        
        // Set email and password using setter methods
        user.setEmail("test@example.com");
        user.setPassword("password");
        
        // Test getter methods to ensure values are set correctly
        assertEquals("test@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
    }
}
