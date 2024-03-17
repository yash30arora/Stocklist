package com.cognizant.Stock.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.Stock.Model.Stock;
import com.cognizant.Stock.Model.StockList;
import com.cognizant.Stock.Service.StockService;

public class StockControllerTest {

    @Mock
    private StockService stockService;

    @InjectMocks
    private StockController stockController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetStock_Success() {
        String country = "USA";
        StockList expectedStockList = new StockList();
        // Add some stocks to the list

        when(stockService.getStock(country)).thenReturn(expectedStockList);

        StockList actualStockList = stockController.getStock(country);

        assertEquals(expectedStockList, actualStockList);
        verify(stockService, times(1)).getStock(country);
    }


    @Test
    public void testGetStock_NullList() {
        String country = "USA";

        when(stockService.getStock(country)).thenReturn(null);

        StockList actualStockList = stockController.getStock(country);

        assertEquals(null, actualStockList);
        verify(stockService, times(1)).getStock(country);
    }
}
