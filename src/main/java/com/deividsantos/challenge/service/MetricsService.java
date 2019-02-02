package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Customer;
import com.deividsantos.challenge.model.Metrics;
import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;
import com.deividsantos.challenge.parser.CustomerParser;
import com.deividsantos.challenge.parser.SaleParser;
import com.deividsantos.challenge.parser.SalesmanParser;

import java.util.List;

class MetricsService {

    Metrics getAll(List<String> lines) {
        return build(CustomerParser.take(lines),
                SalesmanParser.take(lines),
                SaleParser.take(lines));
    }

    Metrics build(List<Customer> customers, List<Salesman> salesmen, List<Sale> sales) {
        return new Metrics.MetricsBuilder()
                .withAmountOfClientes(CustomerService.getAmountOfClients(customers))
                .withAmountOfSalesmen(SalesmanService.getAmountOfSalesman(salesmen))
                .withMostExpensiveSale(SaleService.getMostExpensiveSale(sales))
                .withWorstSalesman(SalesmanService.getWorstSalesman(salesmen, sales))
                .build();
    }
}
