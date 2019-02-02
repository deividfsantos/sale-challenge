package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Item;
import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class SalesmanServiceTest {
    @Test
    public void getAmountOfSalesman() throws Exception {
        assertEquals(Integer.valueOf(3), SalesmanService.getAmountOfSalesman(buildSalesmen()));
    }

    @Test
    public void getWorstSalesman() throws Exception {
        assertEquals("030405020304", SalesmanService.getWorstSalesman(buildSalesmen(), buildSale()));
        assertEquals(null, SalesmanService.getWorstSalesman(new ArrayList<>(), new ArrayList<>()));
        assertEquals("030405020304", SalesmanService.getWorstSalesman(buildSalesmen(), new ArrayList<>()));
        assertEquals(null, SalesmanService.getWorstSalesman(new ArrayList<>(), buildSale()));

    }

    private List<Salesman> buildSalesmen() {
        Salesman salesman = new Salesman.SalesmanBuilder()
                .withCpf("030405020304")
                .withName("Teste")
                .withSalary(BigDecimal.valueOf(10))
                .build();
        Salesman salesman1 = new Salesman.SalesmanBuilder()
                .withCpf("130405020304")
                .withName("Teste1")
                .withSalary(BigDecimal.valueOf(10))
                .build();
        Salesman salesman2 = new Salesman.SalesmanBuilder()
                .withCpf("230405020304")
                .withName("Teste2")
                .withSalary(BigDecimal.valueOf(10))
                .build();
        return asList(salesman, salesman1, salesman2);
    }

    private List<Sale> buildSale() {
        Sale sale1 = new Sale.SaleBuilder()
                .withId("01")
                .withSalesmanName("Teste1")
                .withItems(builditems("10"))
                .build();
        Sale sale2 = new Sale.SaleBuilder()
                .withId("02")
                .withSalesmanName("Teste2")
                .withItems(builditems("20"))
                .build();
        return asList(sale1, sale2);
    }

    private List<Item> builditems(String name) {
        Item item1 = new Item.ItemBuilder()
                .withId(name)
                .withPrice(new BigDecimal(name))
                .withQuantity(Long.valueOf(name))
                .build();
        Item item2 = new Item.ItemBuilder()
                .withId(name)
                .withPrice(new BigDecimal(name).add(BigDecimal.valueOf(5)))
                .withQuantity(Long.valueOf(name))
                .build();
        return asList(item1, item2);
    }

}