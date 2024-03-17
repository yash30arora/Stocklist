package com.cognizant.Stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cognizant.Stock.Model.Stock;
import com.cognizant.Stock.Model.StockList;
@Service
public class StockService {
	 private static final String API_KEY = "b909482384384894bb21d5e1a38eb620";

	    //add the base api url here
	    private static final String API_URL = "https://api.twelvedata.com";

	    private final RestTemplate restTemplate;
	  @Autowired
	    public StockService(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	 
     
	    public StockList getStock(String country) {
	    	String URL = API_URL + "/stocks?country=" + country + "&apikey" + API_KEY;
	    	System.out.println("URL=" + URL);
	    	return restTemplate.getForObject(URL, StockList.class);
	    }

	}