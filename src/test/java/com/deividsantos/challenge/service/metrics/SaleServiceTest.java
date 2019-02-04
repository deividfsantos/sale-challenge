package com.deividsantos.challenge.service.metrics;

import com.deividsantos.challenge.util.ServiceTestUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class SaleServiceTest {
    @Test
    public void getMostExpensiveSaleTest() {
        assertEquals("Sale ID: 02, Items: [Item ID: 20, Quantity: 20, Price: 20, Item ID: 20, Quantity: 20, Price: 25], Salesman Name: Teste2", SaleService.getMostExpensiveSale(ServiceTestUtil.buildSale()).get().toString());
        assertEquals(Optional.empty(), SaleService.getMostExpensiveSale(new ArrayList<>()));
    }

}