package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Item;
import com.deividsantos.challenge.model.Sale;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class SaleServiceTest {
    @Test
    public void getMostExpensiveSaleTest() throws Exception {
        assertEquals("Sale ID: 04, Items: [Item ID: 40, Quantity: 40, Price: 45, Item ID: 40, Quantity: 40, Price: 48], Salesman Name: Teste4", SaleService.getMostExpensiveSaleString(buildSale()));
        assertEquals("There are no sales.", SaleService.getMostExpensiveSaleString(new ArrayList<>()));
    }

    private List<Sale> buildSale() {
        return asList(new Sale.SaleBuilder()
                        .withId("03")
                        .withSalesmanName("Teste3")
                        .withItems(builditems("30"))
                        .build(),
                new Sale.SaleBuilder()
                        .withId("04")
                        .withSalesmanName("Teste4")
                        .withItems(builditems("40"))
                        .build());
    }

    private List<Item> builditems(String name) {
        return asList(new Item.ItemBuilder()
                        .withId(name)
                        .withPrice(new BigDecimal(name).add(BigDecimal.valueOf(5)))
                        .withQuantity(Long.valueOf(name))
                        .build(),
                new Item.ItemBuilder()
                        .withId(name)
                        .withPrice(new BigDecimal(name).add(BigDecimal.valueOf(8)))
                        .withQuantity(Long.valueOf(name))
                        .build());
    }
}