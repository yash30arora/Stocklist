package com.cognizant.Authentication.Exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognizant.Authentication.Exception.UserAlreadyExistException;

public class UserAlreadyExistExceptionTest {

    @Test
    public void testConstructor() {
        String message = "User already exists";
        UserAlreadyExistException exception = new UserAlreadyExistException(message);

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }
}
