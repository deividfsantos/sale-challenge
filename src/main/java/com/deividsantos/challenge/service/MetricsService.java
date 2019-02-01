package com.deividsantos.challenge.service;

import com.deividsantos.challenge.constructor.CustomerConstructor;
import com.deividsantos.challenge.constructor.SaleConstructor;
import com.deividsantos.challenge.constructor.SalesmanConstructor;
import com.deividsantos.challenge.model.Customer;
import com.deividsantos.challenge.model.Item;
import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public Integer getAmountOfClients() {
        return customers.size();
    }

    public Integer getAmountOfSalesman() {
        return salesmen.size();
    }

    public String getWorstSalesman() {
        salesmen.forEach(salesman -> sales.stream()
                .filter(sale -> sale.getSalesmanName().equalsIgnoreCase(salesman.getName()))
                .forEach(sale -> salesman.setSalesAmount(salesman.getSalesAmount() + 1)));

        return salesmen.stream()
                .min(comparing(Salesman::getSalesAmount))
                .orElse(new Salesman.SalesmanBuilder().build())
                .getCpf();
    }

    public List<String> getMostExpensiveSale() {
        return sales.stream()
                .filter(this::isMaxSaleValue)
                .map(Sale::getSaleId)
                .collect(Collectors.toList());
    }

    private boolean isMaxSaleValue(Sale sale) {
        BigDecimal saleValue = sumItemsValues().apply(sale);
        return saleValue.equals(getMaxAllSalesValue());
    }

    private BigDecimal getMaxAllSalesValue() {
        return sales.stream()
                .map(sumItemsValues())
                .max(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);
    }

    private Function<Sale, BigDecimal> sumItemsValues() {
        return sale -> sale.getItems().stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
