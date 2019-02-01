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

public class Metrics {

    public Integer getAmountOfClients(List<String> lines) {
        List<Customer> customers = CustomerConstructor.takeCostumers(lines);
        return customers.size();
    }

    public Integer getAmountOfSalesman(List<String> lines) {
        List<Salesman> salesmen = SalesmanConstructor.takeSalesmen(lines);
        return salesmen.size();
    }

    public Integer getWorstSalesman(List<String> lines) {
        return 0;
    }

    public String getMostExpensiveSale(List<String> lines) {
        List<Sale> sales = SaleConstructor.takeSales(lines);
        BigDecimal maxSaleValue = sales.stream()
                .map(Sale::getItems)
                .map(sumItemValues())
                .sorted(Comparator.reverseOrder())
                .findFirst()
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
