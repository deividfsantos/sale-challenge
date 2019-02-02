package com.deividsantos.challenge.service;

import com.deividsantos.challenge.file.Reader;
import com.deividsantos.challenge.file.Writer;
import com.deividsantos.challenge.model.Customer;
import com.deividsantos.challenge.model.Metrics;
import com.deividsantos.challenge.model.Sale;
import com.deividsantos.challenge.model.Salesman;
import com.deividsantos.challenge.parser.CustomerParser;
import com.deividsantos.challenge.parser.SaleParser;
import com.deividsantos.challenge.parser.SalesmanParser;

import java.nio.file.WatchEvent;
import java.util.List;

public class SalesService {

    private Writer writer;
    private Reader reader;

    public SalesService() {
        this.writer = new Writer();
        this.reader = new Reader();
    }

    public void readEvent(WatchEvent event) {
        String modifiedFileName = getFileName(event);
        List<String> lines = reader.read(modifiedFileName);
        Metrics metrics = buildMetrics(lines);
        writer.writeOutputFile(metrics.toString(), modifiedFileName);
    }

    private String getFileName(WatchEvent event) {
        return event.context().toString().replace(".dat", "");
    }

    private Metrics buildMetrics(List<String> lines) {
        List<Customer> customers = CustomerParser.take(lines);
        List<Salesman> salesmen = SalesmanParser.take(lines);
        List<Sale> sales = SaleParser.take(lines);
        return getMetrics(customers, salesmen, sales);
    }

    private Metrics getMetrics(List<Customer> customers, List<Salesman> salesmen, List<Sale> sales) {
        MetricsService metrics = new MetricsService(customers, salesmen, sales);
        Integer amountOfClients = metrics.getAmountOfClients();
        Integer amountOfSalesman = metrics.getAmountOfSalesman();
        String mostExpensiveSale = metrics.getMostExpensiveSale();
        String worstSalesman = metrics.getWorstSalesman();
        return new Metrics(amountOfClients, amountOfSalesman, mostExpensiveSale, worstSalesman);
    }
}
