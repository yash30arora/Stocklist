package com.cognizant.Wishlist.Exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognizant.Wishlist.Exception.WishListNotFoundException;

public class WishListNotFoundExceptionTest {

    @Test
    public void testConstructor() {
        String message = "Wishlist not found";
        WishListNotFoundException exception = new WishListNotFoundException(message);

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }
}
