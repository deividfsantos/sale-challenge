package com.deividsantos.challenge.util;

import com.deividsantos.challenge.model.Customer;
import com.deividsantos.challenge.model.Item;
import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;

public class ServiceTestUtil {

    public static List<Customer> buildCustomers() {
        return asList(new Customer.Builder()
                        .withBusinessArea("01")
                        .withCnpj("18778509498123")
                        .withName("Teste1")
                        .build(),
                new Customer.Builder()
                        .withBusinessArea("01")
                        .withCnpj("28778509498123")
                        .withName("Teste2")
                        .build(),
                new Customer.Builder()
                        .withBusinessArea("01")
                        .withCnpj("38778509498123")
                        .withName("Teste3")
                        .build());
    }

    public static List<Salesman> buildSalesmen() {
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

    public static List<Sale> buildSale() {
        return asList(new Sale.Builder()
                        .withId("01")
                        .withSalesmanName("Teste1")
                        .withItems(buildItems("10"))
                        .build(),
                new Sale.Builder()
                        .withId("02")
                        .withSalesmanName("Teste2")
                        .withItems(buildItems("20"))
                        .build());
    }

    private static List<Item> buildItems(String name) {
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

    public static List<Item> buildItems() {
        return asList(new Item.Builder()
                        .withId("01")
                        .withPrice(BigDecimal.ONE)
                        .withQuantity(2L)
                        .build(),
                new Item.Builder()
                        .withId("02")
                        .withPrice(BigDecimal.ZERO)
                        .withQuantity(3L)
                        .build(),
                new Item.Builder()
                        .withId("03")
                        .withPrice(BigDecimal.TEN)
                        .withQuantity(4L)
                        .build());
    }
}
