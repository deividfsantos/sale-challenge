package com.deividsantos.challenge.constructor;

import com.deividsantos.challenge.model.Sale;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SaleConstructor {

    private static final String SEPARATOR = "ç";
    private static final Integer SALE_ID_INDEX = 1;
    private static final Integer ITEM_INDEX = 2;
    private static final Integer NAME_INDEX = 3;
    private static final String SALE_ID = "003ç";

    public static List<Sale> takeSales(List<String> inputFileLines) {
        List<String> saleLines = inputFileLines.stream()
                .filter(line -> line.startsWith(SALE_ID))
                .collect(Collectors.toList());
        return buildSale(saleLines);
    }

    private static List<Sale> buildSale(List<String> saleLines) {
        return saleLines.stream()
                .map(saleLine -> saleLine.split(SEPARATOR))
                .map(buildSale())
                .collect(Collectors.toList());
    }

    private static Function<String[], Sale> buildSale() {
        return atributes -> new Sale.SaleBuilder()
                .withId(atributes[SALE_ID_INDEX])
                .withItems(ItemConstructor.buildItem(atributes[ITEM_INDEX]))
                .withSalesmanName(atributes[NAME_INDEX])
                .build();
    }
}
