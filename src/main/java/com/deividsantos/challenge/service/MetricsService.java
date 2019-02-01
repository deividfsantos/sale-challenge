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

public class MetricsService {

    public Integer getAmountOfClients(List<String> lines) {
        List<Customer> customers = CustomerConstructor.takeCostumers(lines);
        return customers.size();
    }

    public Integer getAmountOfSalesman(List<String> lines) {
        List<Salesman> salesmen = SalesmanConstructor.takeSalesmen(lines);
        return salesmen.size();
    }

    public String getWorstSalesman(List<String> lines) {
        List<Salesman> salesmen = SalesmanConstructor.takeSalesmen(lines);
        List<Sale> sales = SaleConstructor.takeSales(lines);
        salesmen.forEach(salesman -> sales.stream()
                .filter(sale -> sale.getSalesmanName().equalsIgnoreCase(salesman.getName()))
                .forEach(sale -> salesman.setSalesAmount(salesman.getSalesAmount() + 1)));

        return salesmen.stream()
                .min(Comparator.comparing(Salesman::getSalesAmount))
                .orElseThrow(() -> new RuntimeException("No salesmen found")).getName();
    }

    public String getMostExpensiveSale(List<String> lines) {
        List<Sale> sales = SaleConstructor.takeSales(lines);
        BigDecimal maxSaleValue = sales.stream()
                .map(sumItemValues().compose(Sale::getItems))
                .max(Comparator.naturalOrder())
                .orElseThrow(RuntimeException::new);

        return sales.stream().filter(sale -> {
            BigDecimal saleValue = sumItemValues().apply(sale.getItems());
            return saleValue.equals(maxSaleValue);
        }).map(Sale::getSaleId)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    private Function<List<Item>, BigDecimal> sumItemValues() {
        return items -> items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
