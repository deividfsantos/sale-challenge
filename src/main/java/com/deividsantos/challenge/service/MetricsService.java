package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Customer;
import com.deividsantos.challenge.model.Metrics;
import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;
import com.deividsantos.challenge.parser.CustomerParser;
import com.deividsantos.challenge.parser.SaleParser;
import com.deividsantos.challenge.parser.SalesmanParser;
import com.deividsantos.challenge.service.metrics.CustomerService;
import com.deividsantos.challenge.service.metrics.SaleService;
import com.deividsantos.challenge.service.metrics.SalesmanService;

import java.util.List;

public class MetricsService {
    String getMetrics(List<String> lines) {
        return build(CustomerParser.parse(lines),
                SalesmanParser.parse(lines),
                SaleParser.parse(lines))
                .getSummarized();
    }

    private Metrics build(List<Customer> customers, List<Salesman> salesmen, List<Sale> sales) {
        return new Metrics.Builder()
                .withAmountOfClientes(CustomerService.getAmountOfClients(customers))
                .withAmountOfSalesmen(SalesmanService.getAmountOfSalesman(salesmen))
                .withMostExpensiveSale(SaleService.getMostExpensiveSale(sales).orElse(null))
                .withWorstSalesman(SalesmanService.getWorstSalesman(salesmen, sales).orElse(null))
                .build();
    }
}
