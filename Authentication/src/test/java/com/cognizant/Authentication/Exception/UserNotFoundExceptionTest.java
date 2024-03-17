package com.cognizant.Authentication.Exception;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognizant.Authentication.Exception.UserNotFoundException;

public class UserNotFoundExceptionTest {

    @Test
    public void testConstructor() {
        String message = "User not found";
        UserNotFoundException exception = new UserNotFoundException(message);

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }
}
