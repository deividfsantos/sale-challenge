package com.deividsantos.challenge.constructor;

import com.deividsantos.challenge.model.Item;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ItemConstructor {

    private static final String ITEM_LIST_SEPARATOR = ",";
    private static final String ITEM_ATRIBUTES_SEPARATOR = "-";

    public static List<Item> buildItem(String line) {
        List<String> items = Arrays.asList(splitItemLine(line));

        return items.stream()
                .map(item -> item.split(ITEM_ATRIBUTES_SEPARATOR))
                .map(ItemConstructor::buildItem)
                .collect(Collectors.toList());
    }

    private static Item buildItem(String[] itemAtributes) {
        return new Item.ItemBuilder()
                .withId(itemAtributes[0])
                .withQuantity(Long.valueOf(itemAtributes[1]))
                .withPrice(new BigDecimal(itemAtributes[2]))
                .build();
    }

    private static String[] splitItemLine(String line) {
        return line.replaceAll("\\[|\\]", "").split(ITEM_LIST_SEPARATOR);
    }
}
