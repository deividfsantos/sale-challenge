package com.deividsantos.challenge.service.metrics;

import com.deividsantos.challenge.model.Customer;

import java.util.List;

public class CustomerService {

    public static Integer getAmountOfClients(List<Customer> customers) {
        return customers.size();
    }
}
