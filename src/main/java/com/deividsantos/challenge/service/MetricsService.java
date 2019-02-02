package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.*;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Comparator.comparing;

public class MetricsService {

    private List<Customer> customers;
    private List<Salesman> salesmen;
    private List<Sale> sales;

    public MetricsService(List<Customer> customers, List<Salesman> salesmen, List<Sale> sales) {
        this.customers = customers;
        this.salesmen = salesmen;
        this.sales = sales;
    }

    public Metrics getAll() {
        Integer amountOfClients = getAmountOfClients();
        Integer amountOfSalesman = getAmountOfSalesman();
        String mostExpensiveSale = getMostExpensiveSale();
        String worstSalesman = getWorstSalesman();
        return new Metrics(amountOfClients, amountOfSalesman, mostExpensiveSale, worstSalesman);
    }

    protected Integer getAmountOfClients() {
        return customers.size();
    }

    protected Integer getAmountOfSalesman() {
        return salesmen.size();
    }

    protected String getWorstSalesman() {
        return salesmen.stream()
                .min(comparing(this::sumSalesmanSales))
                .map(Salesman::getCpf)
                .orElse(null);
    }

    protected String getMostExpensiveSale() {
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
