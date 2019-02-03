package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Item;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ItemServiceTest {
    @Test
    public void sumSaleItemsValueTest() throws Exception {
        assertEquals(BigDecimal.valueOf(42), ItemService.sumValues(buildItems()));
        assertEquals(BigDecimal.valueOf(0), ItemService.sumValues(new ArrayList<>()));
    }

    private List<Item> buildItems() {
        return asList(new Item.ItemBuilder()
                        .withId("01")
                        .withPrice(BigDecimal.ONE)
                        .withQuantity(2L)
                        .build(),
                new Item.ItemBuilder()
                        .withId("02")
                        .withPrice(BigDecimal.ZERO)
                        .withQuantity(3L)
                        .build(),
                new Item.ItemBuilder()
                        .withId("03")
                        .withPrice(BigDecimal.TEN)
                        .withQuantity(4L)
                        .build());
    }

}