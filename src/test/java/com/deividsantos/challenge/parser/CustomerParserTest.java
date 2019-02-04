package com.deividsantos.challenge.parser;

import com.deividsantos.challenge.model.Customer;
import com.deividsantos.challenge.util.ParserTestUtil;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class CustomerParserTest {

    @Test
    public void parseCustomersWithMiscLinesTest() {
        List<Customer> customers = CustomerParser.parse(ParserTestUtil.buildLines());
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
        List<Customer> customers = CustomerParser.parse(ParserTestUtil.buildWrongLines());
        assertEquals(0, customers.size());
    }
}