package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Item;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ItemParser {

    private static final String LIST_SEPARATOR = ",";
    private static final String ATRIBUTES_SEPARATOR = "-";
    private static final Integer ID_INDEX = 0;
    private static final Integer QUANTITY_INDEX = 1;
    private static final Integer PRICE_INDEX = 2;
    private static final String EMPTY_STRING = "";
    private static final String BRACKETS_REGEX = "\\[|\\]";

    public static List<Item> parse(String line) {
        List<String> items = Arrays.asList(removeBrackets(line));
        return items.stream()
                .map(item -> item.split(ATRIBUTES_SEPARATOR))
                .map(ItemParser::build)
                .collect(Collectors.toList());
    }

    private static Item build(String[] itemAtributes) {
        return new Item.ItemBuilder()
                .withId(itemAtributes[ID_INDEX])
                .withQuantity(Long.valueOf(itemAtributes[QUANTITY_INDEX]))
                .withPrice(new BigDecimal(itemAtributes[PRICE_INDEX]))
                .build();
    }

    private static String[] removeBrackets(String line) {
        return line.replaceAll(BRACKETS_REGEX, EMPTY_STRING).split(LIST_SEPARATOR);
    }
}
