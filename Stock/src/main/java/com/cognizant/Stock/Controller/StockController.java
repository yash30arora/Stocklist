package com.cognizant.Stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Stock.Model.Stock;
import com.cognizant.Stock.Model.StockList;
import com.cognizant.Stock.Service.StockService;
@RequestMapping("/Stock")
@RestController
public class StockController {
	
	 private final StockService stockService;
    @Autowired
	    public StockController(StockService stockService) {
	        this.stockService = stockService;
    }


    @GetMapping("/getstock/{country}")
    public StockList getStock(@PathVariable String country) {
       return stockService.getStock(country);
    }

}
