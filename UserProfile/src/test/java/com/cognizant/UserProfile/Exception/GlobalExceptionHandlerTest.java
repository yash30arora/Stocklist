package com.cognizant.UserProfile.Exception;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.UserProfile.Exception.GlobalExceptionHandler;
import com.cognizant.UserProfile.Exception.UserAlreadyExistException;
import com.cognizant.UserProfile.Exception.UserNotFoundException;

public class GlobalExceptionHandlerTest {

    @Test
    public void testHandleUserExistsAlreadyException() {
        // Given
        UserAlreadyExistException exception = new UserAlreadyExistException("User already exists");
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        // When
        ResponseEntity<String> response = handler.handleUserExistsAlreadyException(exception);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("User already exists", response.getBody());
    }

    @Test
    public void testHandleUserNotFoundException() {
        // Given
        UserNotFoundException exception = new UserNotFoundException("User not found");
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        // When
        ResponseEntity<String> response = handler.handleUserNotFoundException(exception);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("User not found", response.getBody());
    }
}
