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
        return build(CustomerParser.parse(lines),
                SalesmanParser.parse(lines),
                SaleParser.parse(lines));
    }

    Metrics build(List<Customer> customers, List<Salesman> salesmen, List<Sale> sales) {
        return new Metrics.Builder()
                .withAmountOfClientes(CustomerService.getAmountOfClients(customers))
                .withAmountOfSalesmen(SalesmanService.getAmountOfSalesman(salesmen))
                .withMostExpensiveSale(SaleService.getMostExpensiveSaleString(sales))
                .withWorstSalesman(SalesmanService.getWorstSalesmanString(salesmen, sales))
                .build();
    }
}
