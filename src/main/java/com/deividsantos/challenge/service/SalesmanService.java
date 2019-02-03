package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

class SalesmanService {

    static Integer getAmountOfSalesman(List<Salesman> salesmen) {
        return salesmen.size();
    }

    static Optional<Salesman> getWorstSalesman(List<Salesman> salesmen, List<Sale> sales) {
        return salesmen.stream()
                .min(comparing(salesman -> SaleService.sumSalesFromSalesman(salesman, sales)));
    }

}
