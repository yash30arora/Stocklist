package com.cognizant.Wishlist.Filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.DefaultJwt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class JwtTokenFilterTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    @InjectMocks
    private JwtTokenFilter jwtTokenFilter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testDoFilter_MissingToken() throws ServletException, IOException {
        when(request.getMethod()).thenReturn(HttpMethod.GET.name());
        when(request.getHeader("Authorization")).thenReturn(null);

        assertThrows(ServletException.class, () -> jwtTokenFilter.doFilter(request, response, filterChain));

        verifyZeroInteractions(filterChain);
    }

    private void verifyZeroInteractions(FilterChain filterChain2) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testDoFilter_InvalidToken() throws ServletException, IOException {
        String token = "InvalidToken";
        when(request.getMethod()).thenReturn(HttpMethod.GET.name());
        when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

        assertThrows(ServletException.class, () -> jwtTokenFilter.doFilter(request, response, filterChain));

        verifyZeroInteractions(filterChain);
    }
}
