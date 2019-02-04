package com.deividsantos.challenge.service;

import com.deividsantos.challenge.service.metrics.ItemService;
import com.deividsantos.challenge.util.ServiceTestUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ItemServiceTest {
    @Test
    public void sumSaleItemsValueTest() throws Exception {
        assertEquals(BigDecimal.valueOf(42), ItemService.sumValues(ServiceTestUtil.buildItems()));
        assertEquals(BigDecimal.valueOf(0), ItemService.sumValues(new ArrayList<>()));
    }

}