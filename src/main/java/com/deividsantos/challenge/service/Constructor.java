package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Customer;
import com.deividsantos.challenge.model.Item;
import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Constructor {

    private static final String SEPARATOR = "ç";
    private static final String SALESMAN_ID = "001";
    private static final String CUSTOMER_ID = "002";
    private static final String SALE_ID = "003";

    public void modelsConstructors(List<String> inputFileLines) {
        List<String> salesmen = inputFileLines.stream().filter(line -> line.startsWith(SALESMAN_ID)).collect(Collectors.toList());
        buildSalesman(salesmen).forEach(System.out::println);
        List<String> customers = inputFileLines.stream().filter(line -> line.startsWith(CUSTOMER_ID)).collect(Collectors.toList());
        buildCustomers(customers).forEach(System.out::println);
        List<String> sales = inputFileLines.stream().filter(line -> line.startsWith(SALE_ID)).collect(Collectors.toList());
        buildSale(sales).forEach(System.out::println);
    }

    private List<Salesman> buildSalesman(List<String> salesmenLines) {
        return salesmenLines.stream()
                .map(saleLine -> saleLine.split(SEPARATOR))
                .map(atributes -> new Salesman(atributes[1], atributes[2], new BigDecimal(atributes[3])))
                .collect(Collectors.toList());
    }

    private List<Customer> buildCustomers(List<String> customersLines) {
        return customersLines.stream()
                .map(saleLine -> saleLine.split(SEPARATOR))
                .map(atributes -> new Customer(atributes[1], atributes[2], atributes[3]))
                .collect(Collectors.toList());
    }

    private List<Sale> buildSale(List<String> salesLines) {
        return salesLines.stream()
                .map(saleLine -> saleLine.split(SEPARATOR))
                .map(atributes -> new Sale(atributes[1], new Item(), atributes[3]))
                .collect(Collectors.toList());
    }
}
