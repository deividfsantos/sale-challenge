package com.deividsantos.challenge.service.metrics;

import com.deividsantos.challenge.util.ServiceTestUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ItemServiceTest {
    @Test
    public void sumSaleItemsValueTest() {
        assertEquals(BigDecimal.valueOf(42), ItemService.sumValues(ServiceTestUtil.buildItems()));
        assertEquals(BigDecimal.valueOf(0), ItemService.sumValues(new ArrayList<>()));
    }

}