package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Item;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

class ItemParser {

    private static final String ITEMS_REGEX = "([0-9]*\\.?[0-9]*)-([0-9]*\\.?[0-9]*)-([0-9]*\\.?[0-9]*)";
    private static final String ITEM_LIST_SEPARATOR_REGEX = "\\[|\\,|\\]";
    private static final String ITEM_ATRIBUTES_SEPARATOR = "-";
    private static final Integer ID_INDEX = 0;
    private static final Integer QUANTITY_INDEX = 1;
    private static final Integer PRICE_INDEX = 2;

    static List<Item> parse(String itemLine) {
        return Stream.of(itemLine)
                .map(line -> asList(line.split(ITEM_LIST_SEPARATOR_REGEX)))
                .map(getEachItem())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static Function<List<String>, List<Item>> getEachItem() {
        return line -> line.stream()
                .filter(item -> item.matches(ITEMS_REGEX))
                .map(item -> item.split(ITEM_ATRIBUTES_SEPARATOR))
                .map(buildItem())
                .collect(Collectors.toList());
    }

    private static Function<String[], Item> buildItem() {
        return itemAtributes -> new Item.Builder()
                .withId(itemAtributes[ID_INDEX])
                .withQuantity(Long.valueOf(itemAtributes[QUANTITY_INDEX]))
                .withPrice(new BigDecimal(itemAtributes[PRICE_INDEX]))
                .build();
    }
}
