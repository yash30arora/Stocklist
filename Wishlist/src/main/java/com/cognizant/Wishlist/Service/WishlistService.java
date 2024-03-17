package com.cognizant.Wishlist.Service;

import java.util.List;

import com.cognizant.Wishlist.Exception.StockExistAlreadyException;
import com.cognizant.Wishlist.Exception.WishListNotFoundException;
import com.cognizant.Wishlist.Model.WishlistStock;

public interface WishlistService {
	 WishlistStock addWishlistStock(WishlistStock wishlistStock) throws StockExistAlreadyException;
	 List<WishlistStock> getAllWishlistStocks(String email);
	 String deleteWishlist(long wishlistid);
	
}
