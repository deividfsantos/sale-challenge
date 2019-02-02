package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Sale;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Comparator.comparing;

class SaleService {

    static String getMostExpensiveSale(List<Sale> sales) {
        return sales.stream()
                .max(comparing(SaleService::sumSaleItemsValue))
                .map(Sale::getSaleId)
                .orElse(null);
    }

    private static BigDecimal sumSaleItemsValue(Sale sale) {
        return ItemService.sumValues(sale.getItems());
    }
}
