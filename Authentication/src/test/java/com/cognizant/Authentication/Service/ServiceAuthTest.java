package com.cognizant.Authentication.Service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.cognizant.Authentication.Exception.UserNotFoundException;
import com.cognizant.Authentication.Service.ServiceAuth;

public class ServiceAuthTest {

    @Test
    public void testGetAuthenticUser_WhenUserExists_ReturnsTrue() throws UserNotFoundException {
        // Mock ServiceAuth implementation
        ServiceAuth serviceAuth = mock(ServiceAuth.class);
        
        // Define behavior
        when(serviceAuth.getAuthenticUser("test@example.com", "password")).thenReturn(true);

        // Invoke the method
        boolean result = serviceAuth.getAuthenticUser("test@example.com", "password");

        // Verify the result
        assertTrue(result);
    }

    @Test
    public void testGetAuthenticUser_WhenUserDoesNotExist_ThrowsException() throws UserNotFoundException {
        // Mock ServiceAuth implementation
        ServiceAuth serviceAuth = mock(ServiceAuth.class);
        
        // Define behavior
        when(serviceAuth.getAuthenticUser("nonexistent@example.com", "password")).thenThrow(new UserNotFoundException("User not found"));

        // Invoke the method and verify the exception
        assertThrows(UserNotFoundException.class, () -> serviceAuth.getAuthenticUser("nonexistent@example.com", "password"));
    }
}
