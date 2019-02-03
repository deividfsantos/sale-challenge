package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Customer;

import java.util.List;

class CustomerService {

    static Integer getAmountOfClients(List<Customer> customers) {
        return customers.size();
    }
}
