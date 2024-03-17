package com.cognizant.Wishlist.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.Wishlist.Exception.StockExistAlreadyException;
import com.cognizant.Wishlist.Model.WishlistStock;
import com.cognizant.Wishlist.Service.WishlistService;

public class WishlistControllerTest {

    @Mock
    private WishlistService wishlistService;

    @InjectMocks
    private WishlistController wishlistController;

	private WishlistStock wishlistStock2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddWishlistStock() throws StockExistAlreadyException {
        WishlistStock wishlistStock = new WishlistStock();
        wishlistStock.setId(1L);
        wishlistStock.setStockName("AAPL");
        wishlistStock.setEmail("test@example.com");

        when(wishlistService.addWishlistStock(wishlistStock)).thenReturn(wishlistStock);

        ResponseEntity<?> responseEntity = wishlistController.addWishlistStock(wishlistStock, "test@example.com");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(wishlistStock, responseEntity.getBody());

        wishlistStock2 = verify(wishlistService).addWishlistStock(wishlistStock);
    }

    @Test
    public void testAddWishlistStock_Conflict() throws StockExistAlreadyException {
        WishlistStock wishlistStock = new WishlistStock();
        wishlistStock.setId(1L);
        wishlistStock.setStockName("AAPL");
        wishlistStock.setEmail("test@example.com");

        when(wishlistService.addWishlistStock(wishlistStock)).thenThrow(new StockExistAlreadyException("Stock already exists"));

        ResponseEntity<?> responseEntity = wishlistController.addWishlistStock(wishlistStock, "test@example.com");

        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("Stock already exists", responseEntity.getBody());

        verify(wishlistService).addWishlistStock(wishlistStock);
    }

    @Test
    public void testGetAllWishlistStocks() {
        List<WishlistStock> wishlistStocks = new ArrayList<>();
        // Add some WishlistStock objects to the list

        when(wishlistService.getAllWishlistStocks("test@example.com")).thenReturn(wishlistStocks);

        ResponseEntity<?> responseEntity = wishlistController.getAllWishlistByEmail("test@example.com");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(wishlistStocks, responseEntity.getBody());

        verify(wishlistService).getAllWishlistStocks("test@example.com");
    }

    @Test
    public void testDeleteWishlist() {
        long wishlistId = 1L;

        when(wishlistService.deleteWishlist(wishlistId)).thenReturn("Wishlist deleted successfully");

        ResponseEntity<String> responseEntity = wishlistController.deleteWishlist(wishlistId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Wishlist deleted successfully", responseEntity.getBody());

        verify(wishlistService).deleteWishlist(wishlistId);
    }
}
