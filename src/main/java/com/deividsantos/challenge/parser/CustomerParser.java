package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Customer;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomerParser {


    private static final String CUSTOMER_REGEX = "002ç([0-9]+)ç([ a-zA-Z áç]+)ç([ a-zA-Z áç]+)";
    private static final Integer CNPJ_INDEX = 1;
    private static final Integer NAME_INDEX = 2;
    private static final Integer AREA_INDEX = 3;

    public static List<Customer> parse(List<String> inputFileLines) {
        Pattern compile = Pattern.compile(CUSTOMER_REGEX);
        return inputFileLines.stream()
                .map(compile::matcher)
                .filter(Matcher::find)
                .map(build())
                .collect(Collectors.toList());
    }

    private static Function<Matcher, Customer> build() {
        return atributes -> new Customer.CustomerBuilder()
                .withCnpj(atributes.group(CNPJ_INDEX))
                .withName(atributes.group(NAME_INDEX))
                .withBusinessArea(atributes.group(AREA_INDEX))
                .build();
    }

}
