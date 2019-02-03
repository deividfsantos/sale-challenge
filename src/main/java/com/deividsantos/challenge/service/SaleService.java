package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

class SaleService {
    static Optional<Sale> getMostExpensiveSale(List<Sale> sales) {
        return sales.stream().max(comparing(SaleService::sumSaleItemsValue));
    }

    static BigDecimal sumSalesFromSalesman(Salesman salesman, List<Sale> sales) {
        return sales.stream()
                .filter(sale -> sale.getSalesmanName().equalsIgnoreCase(salesman.getName()))
                .map(SaleService::sumSaleItemsValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal sumSaleItemsValue(Sale sale) {
        return ItemService.sumValues(sale.getItems());
    }
}