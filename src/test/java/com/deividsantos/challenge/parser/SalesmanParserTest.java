package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class SalesmanParserTest {
    @Test
    public void takeSalesmenWithMiscLinesTest() {
        List<Salesman> salesmen = SalesmanParser.parse(buildLines());
        assertEquals(2, salesmen.size());
        assertEquals("1234567891234", salesmen.get(0).getCpf());
        assertEquals("Pedro", salesmen.get(0).getName());
        assertEquals(BigDecimal.valueOf(50000), salesmen.get(0).getSalary());
        assertEquals("3245678865434", salesmen.get(1).getCpf());
        assertEquals("Paulo", salesmen.get(1).getName());
        assertEquals(BigDecimal.valueOf(40000.99), salesmen.get(1).getSalary());
    }

    @Test
    public void takeSalesmenWithNoCpfTest() {
        List<String> line = singletonList("001ççPedroç50000");
        List<Salesman> salesmen = SalesmanParser.parse(line);
        assertEquals(0, salesmen.size());
    }

    @Test
    public void takeSalesmenWithNoIdTest() {
        List<String> line = singletonList("çççPedro");
        List<Sale> sales = SaleParser.parse(line);
        assertEquals(0, sales.size());
    }

    @Test
    public void parseSalesWithWrongLines() {
        List<Salesman> salesmen = SalesmanParser.parse(buildWrongLines());
        assertEquals(0, salesmen.size());
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
                "001çsagsa324sgg5678865434çPauloç40000.99\n" +
                "002ç23gas456754sfs3454434safs5çgsagasgJose da SilvaçRural\n" +
                "002ç2fsf34f5sg675433444345çEdafsguardo PereiraçRural\n" +
                "003ç10ç[sgag1-10-100,2-30-sf2.dgagsag50,3-40-3.10]çPedro\n" +
                "003ç0fs8ç[1-34gas-10,2-33-1.50,sagg3-40-0.10]çPaulo").split("\n"));
    }
}