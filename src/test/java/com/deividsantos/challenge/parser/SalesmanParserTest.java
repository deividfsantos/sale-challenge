package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;
import com.deividsantos.challenge.util.ParserTestUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class SalesmanParserTest {
    @Test
    public void parseSalesmenWithMiscLinesTest() {
        List<Salesman> salesmen = SalesmanParser.parse(ParserTestUtil.buildLines());
        assertEquals(2, salesmen.size());
        assertEquals("1234567891234", salesmen.get(0).getCpf());
        assertEquals("Pedro", salesmen.get(0).getName());
        assertEquals(BigDecimal.valueOf(50000), salesmen.get(0).getSalary());
        assertEquals("3245678865434", salesmen.get(1).getCpf());
        assertEquals("Paulo", salesmen.get(1).getName());
        assertEquals(BigDecimal.valueOf(40000.99), salesmen.get(1).getSalary());
    }

    @Test
    public void parseSalesmenWithNoCpfTest() {
        List<String> line = singletonList("001ççPedroç50000");
        List<Salesman> salesmen = SalesmanParser.parse(line);
        assertEquals(0, salesmen.size());
    }

    @Test
    public void parseSalesmenWithNoIdTest() {
        List<String> line = singletonList("çççPedro");
        List<Sale> sales = SaleParser.parse(line);
        assertEquals(0, sales.size());
    }

    @Test
    public void parseSalesWithWrongLines() {
        List<Salesman> salesmen = SalesmanParser.parse(ParserTestUtil.buildWrongLines());
        assertEquals(0, salesmen.size());
    }

    @Test
    public void parseSalesmenWithNameDiffTest() {
        List<Salesman> salesmen = SalesmanParser.parse(asList(("001ç1234567891234çPedro Açod çadoa dadaçsaosç50000\n" +
                "001ç3245678865434çPauloç40000.99").split("\n")));
        assertEquals(2, salesmen.size());
        assertEquals("1234567891234", salesmen.get(0).getCpf());
        assertEquals("Pedro Açod çadoa dadaçsaos", salesmen.get(0).getName());
        assertEquals(BigDecimal.valueOf(50000), salesmen.get(0).getSalary());
        assertEquals("3245678865434", salesmen.get(1).getCpf());
        assertEquals("Paulo", salesmen.get(1).getName());
        assertEquals(BigDecimal.valueOf(40000.99), salesmen.get(1).getSalary());
    }
}