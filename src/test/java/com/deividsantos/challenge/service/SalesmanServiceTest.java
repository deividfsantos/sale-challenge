package com.deividsantos.challenge.service;

import com.deividsantos.challenge.service.metrics.SalesmanService;
import com.deividsantos.challenge.util.ServiceTestUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class SalesmanServiceTest {
    @Test
    public void getAmountOfSalesman() throws Exception {
        assertEquals(Integer.valueOf(3), SalesmanService.getAmountOfSalesman(ServiceTestUtil.buildSalesmen()));
    }

    @Test
    public void getWorstSalesman() throws Exception {
        assertEquals("CPF: 030405020304, Name: Teste, Salary: 10", SalesmanService.getWorstSalesman(ServiceTestUtil.buildSalesmen(), ServiceTestUtil.buildSale()).get().toString());
        assertEquals(Optional.empty(), SalesmanService.getWorstSalesman(new ArrayList<>(), new ArrayList<>()));
        assertEquals("CPF: 030405020304, Name: Teste, Salary: 10", SalesmanService.getWorstSalesman(ServiceTestUtil.buildSalesmen(), new ArrayList<>()).get().toString());
        assertEquals(Optional.empty(), SalesmanService.getWorstSalesman(new ArrayList<>(), ServiceTestUtil.buildSale()));
    }

}