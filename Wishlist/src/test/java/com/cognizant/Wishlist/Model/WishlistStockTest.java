package com.cognizant.Wishlist.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WishlistStockTest {

    @Test
    public void testWishlistStockGettersAndSetters() {
        WishlistStock wishlistStock = new WishlistStock();

        wishlistStock.setWishlistId(1L);
        wishlistStock.setEmail("test@example.com");
        wishlistStock.setSymbol("AAPL");
        wishlistStock.setName("Apple Inc.");
        wishlistStock.setCurrency("USD");
        wishlistStock.setExchange("NASDAQ");
        wishlistStock.setMic_code("AAPL_MIC");
        wishlistStock.setCountry("USA");
        wishlistStock.setType("Equity");

        assertEquals(1L, wishlistStock.getWishlistID());
        assertEquals("test@example.com", wishlistStock.getEmail());
        assertEquals("AAPL", wishlistStock.getSymbol());
        assertEquals("Apple Inc.", wishlistStock.getName());
        assertEquals("USD", wishlistStock.getCurrency());
        assertEquals("NASDAQ", wishlistStock.getExchange());
        assertEquals("AAPL_MIC", wishlistStock.getMic_code());
        assertEquals("USA", wishlistStock.getCountry());
        assertEquals("Equity", wishlistStock.getType());
    }
}
