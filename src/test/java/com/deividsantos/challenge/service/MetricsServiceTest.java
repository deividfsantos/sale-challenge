package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class MetricsServiceTest {

    private MetricsService metricsService;

    public MetricsServiceTest() {
        this.metricsService = new MetricsService();
    }

    @Test
    public void buildAllMetricsTest() {
        Metrics allMetrics = metricsService.build(buildCustomers(), buildSalesmen(), buildSale());
        assertEquals(Integer.valueOf(3), allMetrics.getAmountOfClients());
        assertEquals(Integer.valueOf(5), allMetrics.getAmountOfSalesmen());
        assertEquals("030405020304", allMetrics.getWorstSalesman());
        assertEquals("04", allMetrics.getMostExpensiveSale());
    }

    @Test
    public void buildAllMetricsToStringTest() {
        Metrics allMetrics = metricsService.build(buildCustomers(), buildSalesmen(), buildSale());
        assertEquals("\nMetrics:" +
                        "\nAmount of clients: 3" +
                        "\nAmount of salesmen: 5" +
                        "\nMost expensive sale ID: 04" +
                        "\nWorst salesman CNPJ: 030405020304",
                allMetrics.toString());
    }

    @Test
    public void getAllMetricsWithLinesTeste(){
        Metrics metricsWithLines = metricsService.getAll(buildLines());
        assertEquals(Integer.valueOf(3), metricsWithLines.getAmountOfClients());
        assertEquals(Integer.valueOf(2), metricsWithLines.getAmountOfSalesmen());
        assertEquals("3245678865434", metricsWithLines.getWorstSalesman());
        assertEquals("10", metricsWithLines.getMostExpensiveSale());
    }

    @Test
    public void getAllMetricsWithLinesToStringTest() {
        Metrics allMetrics = metricsService.getAll(buildLines());
        assertEquals("\nMetrics:" +
                        "\nAmount of clients: 3" +
                        "\nAmount of salesmen: 2" +
                        "\nMost expensive sale ID: 10" +
                        "\nWorst salesman CNPJ: 3245678865434",
                allMetrics.toString());
    }

    @Test
    public void getAllMetricsWithWrongLinesToStringTest() {
        Metrics allMetrics = metricsService.getAll(buildWrongLines());
        assertEquals("\nMetrics:" +
                        "\nAmount of clients: 0" +
                        "\nAmount of salesmen: 0" +
                        "\nMost expensive sale ID: There are no sales." +
                        "\nWorst salesman CNPJ: There are no salesmen.",
                allMetrics.toString());
    }


    @Test
    public void getAllMetricsWithWrongItemLinesToStringTest() {
        Metrics allMetrics = metricsService.getAll(buildWrongItemLines());
        assertEquals("\nMetrics:" +
                        "\nAmount of clients: 0" +
                        "\nAmount of salesmen: 0" +
                        "\nMost expensive sale ID: There are no sales." +
                        "\nWorst salesman CNPJ: There are no salesmen.",
                allMetrics.toString());
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

    private List<String> buildLines() {
        return asList(("001ç1234567891234çPedroç50000\n" +
                "001ç3245678865434çPauloç40000.99\n" +
                "002ç2345675434544345çJose da SilvaçRural\n" +
                "002ç2345675433444345çEduardo PereiraçRural\n" +
                "002ç2145675433444345çEduardo SilvaçIndustria\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo").split("\n"));
    }

    private List<String> buildWrongLines() {
        return asList(("001ç1234567fasf891234çPedroç50000\n" +
                "001ç324567asf8865434çPauloç40000.99\n" +
                "0s02ç234567sad5434544345çJasasgose da SilvaçRural\n" +
                "002ç23456754sffas33444345çEdusaardo PereiraçRural\n" +
                "002ç2145sfsaf675433444345çEduarsgdggssso SilvaçIndustria\n" +
                "003ç1231224wqe0ç[1-10-100,2-30-2.50,safsafasg3-40-3.10]çPedro\n" +
                "003çwqewe08ç[sfaf1-34-10,2-33-1.50,3gggsa-40-0.10]çPaulo").split("\n"));
    }

    private List<String> buildWrongItemLines() {
        return asList(("001ç1234567fasf891234çPedroç50000\n" +
                "001ç324567asf8865434çPauloç40000.99\n" +
                "0s02ç234567sad5434544345çJasasgose da SilvaçRural\n" +
                "002ç23456754sffas33444345çEdusaardo PereiraçRural\n" +
                "002ç2145sfsaf675433444345çEduarsgdggssso SilvaçIndustria\n" +
                "003ç10ç[1-10-100,2-30-2.50,safsafasg3-40-3.10]çPedro\n" +
                "003ç08ç[sfaf1-34-10,2-33-1.50,3gggsa-40-0.10]çPaulo").split("\n"));
    }
}