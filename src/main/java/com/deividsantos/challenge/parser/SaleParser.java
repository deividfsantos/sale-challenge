package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Sale;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SaleParser {

    private static final Integer SALE_ID_INDEX = 1;
    private static final Integer ITEM_INDEX = 2;
    private static final Integer NAME_INDEX = 3;
    private static final String SALE_REGEX = "003ç([0-9]+)ç(.*)ç(.*)";

    public static List<Sale> parse(List<String> inputFileLines) {
        Pattern compile = Pattern.compile(SALE_REGEX);
        return inputFileLines.stream()
                .map(compile::matcher)
                .filter(Matcher::find)
                .map(build())
                .collect(Collectors.toList());
    }

    private static Function<Matcher, Sale> build() {
        return atributes -> new Sale.Builder()
                .withId(atributes.group(SALE_ID_INDEX))
                .withItems(ItemParser.parse(atributes.group(ITEM_INDEX)))
                .withSalesmanName(atributes.group(NAME_INDEX))
                .build();
    }
}
