package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Sale;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SaleParser {

    private static final String SEPARATOR = "ç";
    private static final Integer SALE_ID_INDEX = 1;
    private static final Integer ITEM_INDEX = 2;
    private static final Integer NAME_INDEX = 3;
    private static final String SALE_ID = "003ç";

    public static List<Sale> take(List<String> inputFileLines) {
        return inputFileLines.stream()
                .filter(line -> line.startsWith(SALE_ID))
                .map(saleLine -> saleLine.split(SEPARATOR))
                .map(build())
                .collect(Collectors.toList());
    }

    private static Function<String[], Sale> build() {
        return atributes -> new Sale.SaleBuilder()
                .withId(atributes[SALE_ID_INDEX])
                .withItems(ItemParser.build(atributes[ITEM_INDEX]))
                .withSalesmanName(atributes[NAME_INDEX])
                .build();
    }
}
