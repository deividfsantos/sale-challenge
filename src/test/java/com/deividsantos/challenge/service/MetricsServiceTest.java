package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Customer;
import com.deividsantos.challenge.model.Item;
import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class MetricsServiceTest {

    private MetricsService metricsService;

    @Before
    public void setup() {
        metricsService = new MetricsService(buildCustomers(), buildSalesmen(), buildSale());
    }

    @Test
    public void getAmountOfClientsTest() throws Exception {
        assertEquals(Integer.valueOf(3), metricsService.getAmountOfClients());
    }

    @Test
    public void getAmountOfSalesmanTest() throws Exception {
        assertEquals(Integer.valueOf(5), metricsService.getAmountOfSalesman());
    }

    @Test
    public void getWorstSalesmanTest() throws Exception {
        assertEquals("030405020304", metricsService.getWorstSalesman());
    }


    @Test
    public void getMostExpensiveSaleTest() throws Exception {
        assertEquals("04", metricsService.getMostExpensiveSale());
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
        Salesman salesman3 = new Salesman.SalesmanBuilder()
                .withCpf("330405020304")
                .withName("Teste3")
                .withSalary(BigDecimal.valueOf(10))
                .build();
        Salesman salesman4 = new Salesman.SalesmanBuilder()
                .withCpf("430405020304")
                .withName("Teste4")
                .withSalary(BigDecimal.valueOf(10))
                .build();
        return asList(salesman, salesman1, salesman2, salesman3, salesman4);
    }

    private List<Customer> buildCustomers() {
        Customer customer1 = new Customer.CustomerBuilder()
                .withBusinessArea("01")
                .withCnpj("18778509498123")
                .withName("Teste1")
                .build();
        Customer customer2 = new Customer.CustomerBuilder()
                .withBusinessArea("01")
                .withCnpj("28778509498123")
                .withName("Teste2")
                .build();
        Customer customer3 = new Customer.CustomerBuilder()
                .withBusinessArea("01")
                .withCnpj("38778509498123")
                .withName("Teste3")
                .build();
        return asList(customer1, customer2, customer3);
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
        return asList(sale1, sale2, sale3, sale4);
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
        Item item3 = new Item.ItemBuilder()
                .withId(name)
                .withPrice(new BigDecimal(name).add(BigDecimal.valueOf(8)))
                .withQuantity(Long.valueOf(name))
                .build();
        return asList(item1, item2, item3);
    }
}