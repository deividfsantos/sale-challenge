package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Salesman;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SalesmanParser {

    private static final String SEPARATOR = "ç";
    private static final Integer CPF_INDEX = 1;
    private static final Integer NAME_INDEX = 2;
    private static final Integer SALARY_INDEX = 3;
    private static final String SALESMAN_ID = "001ç";

    public static List<Salesman> take(List<String> inputFileLines) {
        return inputFileLines.stream()
                .filter(line -> line.startsWith(SALESMAN_ID))
                .map(saleLine -> saleLine.split(SEPARATOR))
                .map(build())
                .collect(Collectors.toList());
    }

    private static Function<String[], Salesman> build() {
        return atributes -> new Salesman.SalesmanBuilder()
                .withCpf(atributes[CPF_INDEX])
                .withName(atributes[NAME_INDEX])
                .withSalary(new BigDecimal(atributes[SALARY_INDEX]))
                .build();
    }
}