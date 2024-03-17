package com.cognizant.Authentication.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.Authentication.Exception.UserNotFoundException;
import com.cognizant.Authentication.Model.UserAuth;
import com.cognizant.Authentication.Repository.RepositoryAuth;

public class ServiceImplAuthTest {

    @Mock
    private RepositoryAuth authRepository;

    @InjectMocks
    private ServiceImplAuth authService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAuthenticUser_UserFound() throws UserNotFoundException {
        String email = "test@example.com";
        String password = "password";
        UserAuth user = new UserAuth(email, password);
        when(authRepository.findByEmailAndPassword(email, password)).thenReturn(Optional.of(user));

        boolean result = authService.getAuthenticUser(email, password);

        assertTrue(result);
    }

    @Test
    public void testGetAuthenticUser_UserNotFound() {
        String email = "nonexistent@example.com";
        String password = "password";
        when(authRepository.findByEmailAndPassword(email, password)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> authService.getAuthenticUser(email, password));
    }
}
