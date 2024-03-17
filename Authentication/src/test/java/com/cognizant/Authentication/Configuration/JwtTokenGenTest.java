package com.cognizant.Authentication.Configuration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.cognizant.Authentication.Configuration.JwtTokenGen;
import com.cognizant.Authentication.Model.UserAuth;

public class JwtTokenGenTest {

    @InjectMocks
    private JwtTokenGen jwtTokenGen;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerateToken() {
        UserAuth user = new UserAuth("test@example.com", "password");
        Map<String, String> tokenMap = jwtTokenGen.generateToken(user);

        assertNotNull(tokenMap);
        assertTrue(tokenMap.containsKey("token"));
        assertTrue(tokenMap.containsKey("email"));
        assertTrue(tokenMap.containsKey("message"));
        assertEquals("test@example.com", tokenMap.get("email"));
        assertEquals("Login Successful", tokenMap.get("message"));
        
       
    }
}
