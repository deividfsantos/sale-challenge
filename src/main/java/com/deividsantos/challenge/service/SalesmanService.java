package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Comparator.comparing;

class SalesmanService {

    static Integer getAmountOfSalesman(List<Salesman> salesmen) {
        return salesmen.size();
    }

    static String getWorstSalesman(List<Salesman> salesmen, List<Sale> sales) {
        return salesmen.stream()
                .min(comparing(salesman -> SalesmanService.sumSalesmanSales(salesman, sales)))
                .map(Salesman::getCpf)
                .orElse("There are no salesmen.");
    }

    private static BigDecimal sumSalesmanSales(Salesman salesman, List<Sale> sales) {
        return sales.stream()
                .filter(sale -> sale.getSalesmanName().equalsIgnoreCase(salesman.getName()))
                .map(sale -> ItemService.sumValues(sale.getItems()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
