package com.cognizant.Wishlist.Exception;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.Wishlist.Exception.GlobalExceptionHandler;
import com.cognizant.Wishlist.Exception.StockExistAlreadyException;
import com.cognizant.Wishlist.Exception.WishListNotFoundException;

public class GlobalExceptionHandlerTest {

    @Test
    public void testHandleStockExistAlreadyException() {
        // Given
        StockExistAlreadyException ex = new StockExistAlreadyException("Stock already exists");
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        // When
        ResponseEntity<String> response = handler.handleStockExistAlreadyException(ex);

        // Then
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("Stock already exists", response.getBody());
    }

    @Test
    public void testHandleWishListNotFoundException() {
        // Given
        WishListNotFoundException ex = new WishListNotFoundException("Wishlist not found");
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        // When
        ResponseEntity<String> response = handler.handleWishListNotFoundException(ex);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Wishlist not found", response.getBody());
    }

    @Test
    public void testHandleGlobalException() {
        // Given
        Exception ex = new Exception("Some internal error occurred");
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        // When
        ResponseEntity<String> response = handler.handleGlobalException(ex);

        // Then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal Server Error", response.getBody());
    }
}
