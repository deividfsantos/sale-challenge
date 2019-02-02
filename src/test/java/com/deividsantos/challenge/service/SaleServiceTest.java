package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Item;
import com.deividsantos.challenge.model.Sale;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class SaleServiceTest {
    @Test
    public void getMostExpensiveSaleTest() throws Exception {
        assertEquals("04",SaleService.getMostExpensiveSale(buildSale()));
        assertEquals("There are no sales.",SaleService.getMostExpensiveSale(new ArrayList<>()));
    }

    private List<Sale> buildSale() {
        Sale sale3 = new Sale.SaleBuilder()
                .withId("03")
                .withSalesmanName("Teste3")
                .withItems(builditems("30"))
                .build();
        Sale sale4 = new Sale.SaleBuilder()
                .withId("04")
                .withSalesmanName("Teste4")
                .withItems(builditems("40"))
                .build();
        return asList(sale3, sale4);
    }

    private List<Item> builditems(String name) {
        Item item2 = new Item.ItemBuilder()
                .withId(name)
                .withPrice(new BigDecimal(name).add(BigDecimal.valueOf(5)))
                .withQuantity(Long.valueOf(name))
                .build();
        Item item3 = new Item.ItemBuilder()
                .withId(name)
                .withPrice(new BigDecimal(name).add(BigDecimal.valueOf(8)))
                .withQuantity(Long.valueOf(name))
                .build();
        return asList(item2, item3);
    }
}