package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.*;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Comparator.comparing;

class MetricsService {

    private List<Customer> customers;
    private List<Salesman> salesmen;
    private List<Sale> sales;

    MetricsService(List<Customer> customers, List<Salesman> salesmen, List<Sale> sales) {
        this.customers = customers;
        this.salesmen = salesmen;
        this.sales = sales;
    }

    Metrics getAll() {
        return new Metrics.MetricsBuilder()
                .withAmountOfClientes(getAmountOfClients())
                .withAmountOfSalesmen(getAmountOfSalesman())
                .withMostExpensiveSale(getMostExpensiveSale())
                .withWorstSalesman(getWorstSalesman())
                .build();
    }

    Integer getAmountOfClients() {
        return customers.size();
    }

    Integer getAmountOfSalesman() {
        return salesmen.size();
    }

    String getWorstSalesman() {
        return salesmen.stream()
                .min(comparing(this::sumSalesmanSales))
                .map(Salesman::getCpf)
                .orElse(null);
    }

    String getMostExpensiveSale() {
        return sales.stream()
                .max(comparing(this::sumSaleItemsValue))
                .map(Sale::getSaleId)
                .orElse(null);
    }

    private BigDecimal sumSalesmanSales(Salesman salesman) {
        return sales.stream()
                .filter(sale -> sale.getSalesmanName().equalsIgnoreCase(salesman.getName()))
                .map(this::sumSaleItemsValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal sumSaleItemsValue(Sale sale) {
        return sale.getItems().stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
