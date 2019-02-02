package com.deividsantos.challenge.service;

import com.deividsantos.challenge.model.Item;

import java.math.BigDecimal;
import java.util.List;

class ItemService {

    static BigDecimal sumValues(List<Item> items) {
        return items.stream()
                .map(ItemService::getMultipliedPriceQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal getMultipliedPriceQuantity(Item item) {
        return item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
    }

}
