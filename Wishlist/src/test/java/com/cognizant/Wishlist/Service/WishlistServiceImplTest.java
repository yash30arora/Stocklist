package com.cognizant.Wishlist.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.Wishlist.Exception.StockExistAlreadyException;
import com.cognizant.Wishlist.Model.WishlistStock;
import com.cognizant.Wishlist.Repository.WishlistRepository;
import com.cognizant.Wishlist.Service.WishlistService;
import com.cognizant.Wishlist.Service.WishlistServiceImpl;

public class WishlistServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(WishlistServiceImplTest.class);

    @Mock
    private WishlistRepository wishlistRepository;

    @InjectMocks
    private WishlistService wishlistService = new WishlistServiceImpl();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void testDeleteWishlist() {
        long wishlistId = 1L;
        doNothing().when(wishlistRepository).deleteById(wishlistId);
        String result = wishlistService.deleteWishlist(wishlistId);
        assertEquals("Wishlist Deleted", result);
    }
}
