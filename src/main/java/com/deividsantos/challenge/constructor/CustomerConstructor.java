package com.deividsantos.challenge.constructor;

import com.deividsantos.challenge.model.Customer;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomerConstructor {

    private static final String SEPARATOR = "ç";
    private static final Integer CNPJ_INDEX = 1;
    private static final Integer NAME_INDEX = 2;
    private static final Integer AREA_INDEX = 3;
    private static final String CUSTOMER_ID = "002ç";

    public static List<Customer> takeCustomers(List<String> inputFileLines) {
        return inputFileLines.stream()
                .filter(line -> line.startsWith(CUSTOMER_ID))
                .map(saleLine -> saleLine.split(SEPARATOR))
                .map(buildCostumer())
                .collect(Collectors.toList());
    }

    private static Function<String[], Customer> buildCostumer() {
        return atributes -> new Customer.CustomerBuilder()
                .withCnpj(atributes[CNPJ_INDEX])
                .withName(atributes[NAME_INDEX])
                .withBusinessArea(atributes[AREA_INDEX])
                .build();
    }

}
