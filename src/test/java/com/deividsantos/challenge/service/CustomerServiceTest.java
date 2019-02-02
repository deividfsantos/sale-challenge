package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Customer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class CustomerServiceTest {
    @Test
    public void getAmountOfClientsTest() throws Exception {
        assertEquals(Integer.valueOf(3), CustomerService.getAmountOfClients(buildCustomers()));
        assertEquals(Integer.valueOf(0), CustomerService.getAmountOfClients(new ArrayList<>()));
    }

    private List<Customer> buildCustomers() {
        Customer customer1 = new Customer.CustomerBuilder()
                .withBusinessArea("01")
                .withCnpj("18778509498123")
                .withName("Teste1")
                .build();
        Customer customer2 = new Customer.CustomerBuilder()
                .withBusinessArea("01")
                .withCnpj("28778509498123")
                .withName("Teste2")
                .build();
        Customer customer3 = new Customer.CustomerBuilder()
                .withBusinessArea("01")
                .withCnpj("38778509498123")
                .withName("Teste3")
                .build();
        return asList(customer1, customer2, customer3);
    }

}