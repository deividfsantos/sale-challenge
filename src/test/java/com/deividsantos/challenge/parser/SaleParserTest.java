package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Sale;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class SaleParserTest {

    @Test
    public void parseSalesWithMiscLinesTest() {
        List<Sale> sales = SaleParser.parse(buildLines());
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
        List<Sale> sales = SaleParser.parse(buildWrongLines());
        assertEquals(0, sales.size());
    }

    @Test
    public void takeSalesWithNoIdTest() {
        List<String> line = singletonList("003çç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
        List<Sale> sales = SaleParser.parse(line);
        assertEquals(0, sales.size());
    }

    @Test
    public void takeCustomersWithNoIdTest() {
        List<String> line = singletonList("çççPedro");
        List<Sale> sales = SaleParser.parse(line);
        assertEquals(0, sales.size());
    }

    private List<String> buildLines() {
        return asList(("001ç1234567891234çPedroç50000\n" +
                "001ç3245678865434çPauloç40000.99\n" +
                "002ç2345675434544345çJose da SilvaçRural\n" +
                "002ç2345675433444345çEduardo PereiraçRural\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo").split("\n"));
    }

    private List<String> buildWrongLines() {
        return asList(("dofhiofhieif\n" +
                "001çsagsasd324sgg5678865434svdçvPauloç40000.99\n" +
                "002ç23gas456dssd7543454sf434safs5çgsagasgJose da SilvaçRural\n" +
                "002ç2345sg6754ds33444345çEdafsguardo PereiraçRural\n" +
                "003çsds10ç[sgag1-ds10-100,2-30-2.dgagsag50,3-40-3.10]çPedro\n" +
                "003ç08ç[1-34dsass-10,2-33-1.50,sagg3-40-0.10]çPaulo").split("\n"));
    }
}