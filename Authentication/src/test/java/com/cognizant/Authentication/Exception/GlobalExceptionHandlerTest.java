package com.cognizant.Authentication.Exception;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.Authentication.Exception.GlobalExceptionHandler;
import com.cognizant.Authentication.Exception.UserNotFoundException;

public class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler exceptionHandler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHandleUserNotFoundException() {
        UserNotFoundException ex = new UserNotFoundException("User not found");
        ResponseEntity<String> response = exceptionHandler.handleUserNotFoundException(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("User not found", response.getBody());
    }

    @Test
    public void testHandleAllExceptions() {
        Exception ex = new Exception("Unexpected error");
        ResponseEntity<String> response = exceptionHandler.handleAllExceptions(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("An unexpected error occurred", response.getBody());
    }
}
