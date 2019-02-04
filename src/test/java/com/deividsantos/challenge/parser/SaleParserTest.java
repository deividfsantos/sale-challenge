package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.util.ParserTestUtil;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class SaleParserTest {

    @Test
    public void parseSalesWithMiscLinesTest() {
        List<Sale> sales = SaleParser.parse(ParserTestUtil.buildLines());
        assertEquals(2, sales.size());
        assertEquals("10", sales.get(0).getSaleId());
        assertEquals("Pedro", sales.get(0).getSalesmanName());
        assertEquals(3, sales.get(0).getItems().size());
        assertEquals("08", sales.get(1).getSaleId());
        assertEquals("Paulo", sales.get(1).getSalesmanName());
        assertEquals(3, sales.get(1).getItems().size());
    }

    @Test
    public void parseSalesWithWrongLines() {
        List<Sale> sales = SaleParser.parse(ParserTestUtil.buildWrongLines());
        assertEquals(0, sales.size());
    }

    @Test
    public void parseSalesWithNoIdTest() {
        List<String> line = singletonList("003çç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
        List<Sale> sales = SaleParser.parse(line);
        assertEquals(0, sales.size());
    }

    @Test
    public void parseCustomersWithNoIdTest() {
        List<String> line = singletonList("çççPedro");
        List<Sale> sales = SaleParser.parse(line);
        assertEquals(0, sales.size());
    }

}