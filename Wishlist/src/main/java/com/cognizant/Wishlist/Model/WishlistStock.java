package com.cognizant.Wishlist.Model;

import java.util.function.LongFunction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WishlistStock {
	 @Id
	   @GeneratedValue(strategy = GenerationType.SEQUENCE)
	        private Long wishlistid;
            private String email;
			private String symbol;
			private String name;
			private String currency;
			private String exchange;
			private String mic_code;
			private String country;
			private String type;

		 public WishlistStock() {
			
		}

		public WishlistStock(Long wishlistid, String email,String symbol, String name, String currency, String exchange,String mic_code,String country,String type) {
		   this.wishlistid=wishlistid;
			this.email=email;
		    this.symbol = symbol;
		    this.name = name;
		    this.currency = currency;
		    this.exchange = exchange;
		    this.mic_code = mic_code;
		    this.country = country;
		    this.type = type;
		}
		
		public Long getWishlistID() {
		    return wishlistid;
		}

		public void setWishlistId(Long wishlistid) {
		    this.wishlistid = wishlistid;
		}
		
		public String getEmail() {
		    return email;
		}

		public void setEmail(String email) {
		    this.email = email;
		}
		
		
		public String getSymbol() {
		    return symbol;
		}

		public void setSymbol(String symbol) {
		    this.symbol = symbol;
		}

		public String getName() {
		    return name;
		}

		public void setName(String name) {
		    this.name = name;
		}

		public String getCurrency() {
		    return currency;
		}

		public void setCurrency(String currency) {
		    this.currency = currency;
		}

		public String getExchange() {
		    return exchange;
		}

		public void setExchange(String exchange) {
		    this.exchange = exchange;
		}

		public String getMic_code() {
		    return mic_code;
		}

		public void setMic_code(String mic_code) {
		    this.mic_code = mic_code;
		}

		public String getCountry() {
		    return country;
		}

		public void setCountry(String country) {
		    this.country = country;
		}

		public String getType() {
		    return type;
		}

		public void setType(String type) {
		    this.type = type;
		}

		public void setId(long l) {
			// TODO Auto-generated method stub
			
		}

		public void setStockName(String string) {
			// TODO Auto-generated method stub
			
		}

		

		}




