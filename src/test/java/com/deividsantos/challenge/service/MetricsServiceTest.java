package com.deividsantos.challenge.service;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class MetricsServiceTest {

    private MetricsService metricsService;

    public MetricsServiceTest() {
        this.metricsService = new MetricsService();
    }

    @Test
    public void getAllMetricsWithLinesToStringTest() {
        String allMetrics = metricsService.getMetrics(buildLines());
        assertEquals("Amount of clients: 3" +
                        "\nAmount of salesmen: 2" +
                        "\nMost expensive sale ID: 10" +
                        "\nWorst salesman CPF: 3245678865434",
                allMetrics);
    }

    @Test
    public void getAllMetricsWithWrongLinesToStringTest() {
        String allMetrics = metricsService.getMetrics(buildWrongLines());
        assertEquals("Amount of clients: 0" +
                        "\nAmount of salesmen: 0" +
                        "\nMost expensive sale ID: There are no sales." +
                        "\nWorst salesman CPF: There are no salesmen.",
                allMetrics);
    }


    @Test
    public void getAllMetricsWithWrongItemLinesToStringTest() {
        String metrics = metricsService.getMetrics(buildWrongItemLines());
        assertEquals("Amount of clients: 0" +
                        "\nAmount of salesmen: 0" +
                        "\nMost expensive sale ID: There are no sales." +
                        "\nWorst salesman CPF: There are no salesmen.",
                metrics);
    }

    private List<String> buildLines() {
        return asList(("001ç1234567891234çPedroç50000\n" +
                "001ç3245678865434çPauloç40000.99\n" +
                "002ç2345675434544345çJose da SilvaçRural\n" +
                "002ç2345675433444345çEduardo PereiraçRural\n" +
                "002ç2145675433444345çEduardo SilvaçIndustria\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo").split("\n"));
    }

    private List<String> buildWrongLines() {
        return asList(("001ç1234567fasf891234çPedroç50000\n" +
                "001ç324567asf8865434çPauloç40000.99\n" +
                "0s02ç234567sad5434544345çJasasgose da SilvaçRural\n" +
                "002ç23456754sffas33444345çEdusaardo PereiraçRural\n" +
                "002ç2145sfsaf675433444345çEduarsgdggssso SilvaçIndustria\n" +
                "003ç1231224wqe0ç[1-10-100,2-30-2.50,safsafasg3-40-3.10]çPedro\n" +
                "003çwqewe08ç[sfaf1-34-10,2-33-1.50,3gggsa-40-0.10]çPaulo").split("\n"));
    }

    private List<String> buildWrongItemLines() {
        return asList(("001ç1234567fasf891234çPedroç50000\n" +
                "001ç324567asf8865434çPauloç40000.99\n" +
                "0s02ç234567sad5434544345çJasasgose da SilvaçRural\n" +
                "002ç23456754sffas33444345çEdusaardo PereiraçRural\n" +
                "002ç2145sfsaf675433444345çEduarsgdggssso SilvaçIndustria\n" +
                "003ç1s0ç[1-10-sd100,2-3sd0-2.50,safsafasg3-40-3sd.10]çPedro\n" +
                "003ç0ss8ç[sfaf1-3s4-10,2-33sd-1.50,3gggsa-40-0.10]çPaulo").split("\n"));
    }
}