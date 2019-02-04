package com.deividsantos.challenge.service.metrics;

import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

public class SalesmanService {

    public static Integer getAmountOfSalesman(List<Salesman> salesmen) {
        return salesmen.size();
    }

    public static Optional<Salesman> getWorstSalesman(List<Salesman> salesmen, List<Sale> sales) {
        return salesmen.stream()
                .min(comparing(salesman -> SaleService.sumSalesFromSalesman(salesman, sales)));
    }

}
