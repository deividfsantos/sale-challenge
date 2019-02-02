package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Item;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class ItemServiceTest {
    @Test
    public void sumSaleItemsValueTest() throws Exception {
        assertEquals(BigDecimal.valueOf(42),ItemService.sumValues(builditems()));
    }

    private List<Item> builditems() {
        Item item1 = new Item.ItemBuilder()
                .withId("01")
                .withPrice(BigDecimal.ONE)
                .withQuantity(2L)
                .build();
        Item item2 = new Item.ItemBuilder()
                .withId("02")
                .withPrice(BigDecimal.ZERO)
                .withQuantity(3L)
                .build();
        Item item3 = new Item.ItemBuilder()
                .withId("03")
                .withPrice(BigDecimal.TEN)
                .withQuantity(4L)
                .build();
        return asList(item1, item2, item3);
    }

}