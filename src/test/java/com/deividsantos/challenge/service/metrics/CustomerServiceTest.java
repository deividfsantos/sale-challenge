package com.deividsantos.challenge.service.metrics;

import com.deividsantos.challenge.util.ServiceTestUtil;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CustomerServiceTest {
    @Test
    public void getAmountOfClientsTest() {
        assertEquals(Integer.valueOf(3), CustomerService.getAmountOfClients(ServiceTestUtil.buildCustomers()));
        assertEquals(Integer.valueOf(0), CustomerService.getAmountOfClients(new ArrayList<>()));
    }
}