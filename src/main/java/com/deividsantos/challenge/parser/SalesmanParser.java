package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Salesman;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SalesmanParser {

    private static final String SALESMAN_REGEX = "001ç([0-9]+)ç([ a-zA-Z áç]+)ç([-+]?[0-9]*\\.?[0-9]*)";
    private static final Integer CPF_INDEX = 1;
    private static final Integer NAME_INDEX = 2;
    private static final Integer SALARY_INDEX = 3;

    public static List<Salesman> parse(List<String> inputFileLines) {
        Pattern compile = Pattern.compile(SALESMAN_REGEX);
        return inputFileLines.stream()
                .map(compile::matcher)
                .filter(Matcher::find)
                .map(build())
                .collect(Collectors.toList());
    }

    private static Function<Matcher, Salesman> build() {
        return atributes -> new Salesman.SalesmanBuilder()
                .withCpf(atributes.group(CPF_INDEX))
                .withName(atributes.group(NAME_INDEX))
                .withSalary(new BigDecimal(atributes.group(SALARY_INDEX)))
                .build();
    }
}