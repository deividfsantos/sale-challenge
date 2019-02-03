package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Item;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemParserTest {
    @Test
    public void parseItemsWithNormalLinesTest() {
        List<Item> items = ItemParser.parse("[1-10-100,2-30-2.50,3-40-3.10]");
        assertEquals(3, items.size());
        assertEquals("1", items.get(0).getId());
        assertEquals(Long.valueOf("10"), items.get(0).getQuantity());
        assertEquals(BigDecimal.valueOf(100), items.get(0).getPrice());
        assertEquals("2", items.get(1).getId());
        assertEquals(Long.valueOf("30"), items.get(1).getQuantity());
        assertEquals(new BigDecimal("2.50"), items.get(1).getPrice());
        assertEquals("3", items.get(2).getId());
        assertEquals(Long.valueOf("40"), items.get(2).getQuantity());
        assertEquals(new BigDecimal("3.10"), items.get(2).getPrice());
    }

    @Test
    public void parseItemsWithWrongLinesTest() {
        List<Item> items = ItemParser.parse("[1-34-dw10,2-33-dwdw1.50,3-4wdwdw0-0.10]");
        assertEquals(0, items.size());
    }

    @Test
    public void parseItemsWithOneItemTest() {
        List<Item> items = ItemParser.parse("[3-15-20]");
        assertEquals(1, items.size());
        assertEquals("3", items.get(0).getId());
        assertEquals(Long.valueOf("15"), items.get(0).getQuantity());
        assertEquals(BigDecimal.valueOf(20), items.get(0).getPrice());
    }

    @Test
    public void parseItemsWithTwoItemTest() {
        List<Item> items = ItemParser.parse("[3-15-20,1-12-1000.50]");
        assertEquals(2, items.size());
        assertEquals("3", items.get(0).getId());
        assertEquals(Long.valueOf("15"), items.get(0).getQuantity());
        assertEquals(BigDecimal.valueOf(20), items.get(0).getPrice());
        assertEquals("1", items.get(1).getId());
        assertEquals(Long.valueOf("12"), items.get(1).getQuantity());
        assertEquals(new BigDecimal("1000.50"), items.get(1).getPrice());
    }

    @Test
    public void parseItemsWithOneWrongItemTest() {
        List<Item> items = ItemParser.parse("[1-10-100,2-3sdasfs0-2.50,3-40-3.10]");
        assertEquals(2, items.size());
        assertEquals("1", items.get(0).getId());
        assertEquals(Long.valueOf("10"), items.get(0).getQuantity());
        assertEquals(BigDecimal.valueOf(100), items.get(0).getPrice());
        assertEquals("3", items.get(1).getId());
        assertEquals(Long.valueOf("40"), items.get(1).getQuantity());
        assertEquals(new BigDecimal("3.10"), items.get(1).getPrice());
    }
}