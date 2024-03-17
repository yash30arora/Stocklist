package com.cognizant.Stock.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.cognizant.Stock.Model.StockList;

public class StockServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private StockService stockService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetStock_Success() {
        String country = "USA";
        String expectedUrl = "https://api.twelvedata.com/stocks?country=USA&apikey=b909482384384894bb21d5e1a38eb620";
        StockList expectedStockList = new StockList();
        // Add some stocks to the list

        when(restTemplate.getForObject(expectedUrl, StockList.class)).thenReturn(expectedStockList);

        StockList actualStockList = stockService.getStock(country);

        assertEquals(expectedStockList, actualStockList);
        verify(restTemplate, times(1)).getForObject(expectedUrl, StockList.class);
    }
}
