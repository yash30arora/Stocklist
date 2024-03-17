package com.cognizant.Authentication.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.Authentication.Exception.UserNotFoundException;
import com.cognizant.Authentication.Model.UserAuth;
import com.cognizant.Authentication.Service.ServiceAuth;

public class ControllerAuthenticationTest {

    @Mock
    private ServiceAuth authService;

    @InjectMocks
    private ControllerAuthentication authenticationController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginUser_NullEmailAndPassword() {
        UserAuth user = new UserAuth(null, null);
        
        ResponseEntity<?> actualResponse = authenticationController.loginUser(user);

        assertEquals(HttpStatus.UNAUTHORIZED, actualResponse.getStatusCode());
    }

 
}
