package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Item;
import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class SalesmanServiceTest {
    @Test
    public void getAmountOfSalesman() throws Exception {
        assertEquals(Integer.valueOf(3), SalesmanService.getAmountOfSalesman(buildSalesmen()));
    }

    @Test
    public void getWorstSalesman() throws Exception {
        assertEquals("CPF: 030405020304, Name: Teste, Salary: 10", SalesmanService.getWorstSalesman(buildSalesmen(), buildSale()).get().toString());
        assertEquals(Optional.empty(), SalesmanService.getWorstSalesman(new ArrayList<>(), new ArrayList<>()));
        assertEquals("CPF: 030405020304, Name: Teste, Salary: 10", SalesmanService.getWorstSalesman(buildSalesmen(), new ArrayList<>()).get().toString());
        assertEquals(Optional.empty(), SalesmanService.getWorstSalesman(new ArrayList<>(), buildSale()));

    }

    private List<Salesman> buildSalesmen() {
        return asList(new Salesman.Builder()
                        .withCpf("030405020304")
                        .withName("Teste")
                        .withSalary(BigDecimal.valueOf(10))
                        .build(),
                new Salesman.Builder()
                        .withCpf("130405020304")
                        .withName("Teste1")
                        .withSalary(BigDecimal.valueOf(10))
                        .build(),
                new Salesman.Builder()
                        .withCpf("230405020304")
                        .withName("Teste2")
                        .withSalary(BigDecimal.valueOf(10))
                        .build());
    }

    private List<Sale> buildSale() {
        return asList(new Sale.Builder()
                        .withId("01")
                        .withSalesmanName("Teste1")
                        .withItems(builditems("10"))
                        .build(),
                new Sale.Builder()
                        .withId("02")
                        .withSalesmanName("Teste2")
                        .withItems(builditems("20"))
                        .build());
    }

    private List<Item> builditems(String name) {
        return asList(new Item.Builder()
                        .withId(name)
                        .withPrice(new BigDecimal(name))
                        .withQuantity(Long.valueOf(name))
                        .build(),
                new Item.Builder()
                        .withId(name)
                        .withPrice(new BigDecimal(name).add(BigDecimal.valueOf(5)))
                        .withQuantity(Long.valueOf(name))
                        .build());
    }

}