package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Customer;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class CustomerParserTest {

    @Test
    public void parseCustomersWithMiscLinesTest() {
        List<Customer> customers = CustomerParser.parse(buildLines());
        assertEquals(2, customers.size());
        assertEquals("2345675434544345", customers.get(0).getCnpj());
        assertEquals("Rural", customers.get(0).getBusinessArea());
        assertEquals("Jose da Silva", customers.get(0).getName());
        assertEquals("2345675433444345", customers.get(1).getCnpj());
        assertEquals("Rural", customers.get(1).getBusinessArea());
        assertEquals("Eduardo Pereira", customers.get(1).getName());
    }

    @Test
    public void parseCustomerTest() {
        List<Customer> customers = CustomerParser.parse(Collections.singletonList("002ç2345675434544345çJose da Silva AçafraoçRural"));
        assertEquals(1, customers.size());
        assertEquals("2345675434544345", customers.get(0).getCnpj());
        assertEquals("Rural", customers.get(0).getBusinessArea());
        assertEquals("Jose da Silva Açafrao", customers.get(0).getName());
    }

    @Test
    public void parseCustomerWithLetterInCnpjTest() {
        List<Customer> customers = CustomerParser.parse(Collections.singletonList("002ç2345etty34544345çJose da Silva AçafraoçRural"));
        assertEquals(0, customers.size());
    }

    @Test
    public void takeCustomersWithNoNameTest() {
        List<String> line = singletonList("002ç2345675434544345ççRural");
        List<Customer> customers = CustomerParser.parse(line);
        assertEquals(0, customers.size());
    }

    @Test
    public void takeCustomersWithNoCnpjTest() {
        List<String> line = singletonList("002çççRural");
        List<Customer> customers = CustomerParser.parse(line);
        assertEquals(0, customers.size());
    }

    @Test
    public void takeCustomersWithNoIdTest() {
        List<String> line = singletonList("çççRural");
        List<Customer> customers = CustomerParser.parse(line);
        assertEquals(0, customers.size());
    }

    @Test
    public void parseSalesWithWrongLines() {
        List<Customer> customers = CustomerParser.parse(buildWrongLines());
        assertEquals(0, customers.size());
    }

    private List<String> buildLines() {
        return asList(("001ç3245678865434çPauloç40000.99\n" +
                "002ç2345675434544345çJose da SilvaçRural\n" +
                "002ç2345675433444345çEduardo PereiraçRural\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo").split("\n"));
    }

    private List<String> buildWrongLines() {
        return asList(("dofhiofhieif\n" +
                "002ç23gas4567543454434safs5çgsagasgJose da SilvaçRural\n" +
                "002ç2345sg675433444345çEdafsguardo PereiraçRural\n" +
                "003ç08ç[1-34gas-10,2-33-1.50,sagg3-40-0.10]çPaulo").split("\n"));
    }
}