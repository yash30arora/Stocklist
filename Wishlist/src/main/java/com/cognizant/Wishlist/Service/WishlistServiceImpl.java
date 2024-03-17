package com.cognizant.Wishlist.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Wishlist.Exception.StockExistAlreadyException;
import com.cognizant.Wishlist.Model.WishlistStock;
import com.cognizant.Wishlist.Repository.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService {

    private static final Logger logger = LoggerFactory.getLogger(WishlistServiceImpl.class);

    @Autowired
    WishlistRepository wishlistRepository;

    @Override
    public WishlistStock addWishlistStock(WishlistStock wishlistStock) throws StockExistAlreadyException {
        logger.info("Adding wishlist stock: {}", wishlistStock);
        Optional<WishlistStock> existingProduct = wishlistRepository
                .findByEmailAndSymbol(wishlistStock.getEmail(), wishlistStock.getSymbol());
        if (existingProduct.isPresent()) {
            throw new StockExistAlreadyException("Stock already exists");
        } else {
            wishlistRepository.save(wishlistStock);
            return wishlistStock;
        }
    }

    @Override
    public List<WishlistStock> getAllWishlistStocks(String email) {
        logger.info("Fetching wishlist stocks for email: {}", email);
        List<WishlistStock> allStocks = wishlistRepository.findByEmail(email);
        return allStocks;
    }

    @Override
    public String deleteWishlist(long wishlistid) {
        logger.info("Deleting wishlist with ID: {}", wishlistid);
        wishlistRepository.deleteById(wishlistid);
        return "Wishlist Deleted";
    }
}
