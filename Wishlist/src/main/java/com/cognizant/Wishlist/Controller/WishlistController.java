package com.cognizant.Wishlist.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Wishlist.Exception.StockExistAlreadyException;
import com.cognizant.Wishlist.Exception.WishListNotFoundException;
import com.cognizant.Wishlist.Model.WishlistStock;
import com.cognizant.Wishlist.Service.WishlistService;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    private static final Logger logger = LoggerFactory.getLogger(WishlistController.class);

    @Autowired
    WishlistService wishlistService;

    @PostMapping("/addWishlist/{email}")
    public ResponseEntity<?> addWishlistStock(@RequestBody WishlistStock wishlistStock, @PathVariable("email") String email) {
        wishlistStock.setEmail(email);
        try {
            wishlistService.addWishlistStock(wishlistStock);
            logger.info("Wishlist stock added successfully: {}", wishlistStock);
            return new ResponseEntity<>(wishlistStock, HttpStatus.OK);
        } catch (StockExistAlreadyException e) {
            logger.error("Error adding wishlist stock: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getWishlists/{email}")
    public ResponseEntity<?> getAllWishlistByEmail(@PathVariable("email") String email) {
        logger.info("Fetching wishlist stocks for email: {}", email);
        return new ResponseEntity<>(wishlistService.getAllWishlistStocks(email), HttpStatus.OK);
    }

    @DeleteMapping("/deleteWishlist/{wishlistid}")
    public ResponseEntity<String> deleteWishlist(@PathVariable long wishlistid) {
        logger.info("Deleting wishlist with ID: {}", wishlistid);
        return new ResponseEntity<>(wishlistService.deleteWishlist(wishlistid), HttpStatus.OK);
    }
}
