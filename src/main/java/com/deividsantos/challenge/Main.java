package com.deividsantos.challenge;

import com.deividsantos.challenge.file.Reader;
import com.deividsantos.challenge.file.Watcher;
import com.deividsantos.challenge.file.Writer;
import com.deividsantos.challenge.model.Metrics;
import com.deividsantos.challenge.service.MetricsService;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Watcher watcher = new Watcher();

        while (true) {
            List<WatchEvent> events = watcher.watch();
            events.forEach(Main::build);
        }
    }

    private static void build(WatchEvent event) {
        Reader reader = new Reader();
        Writer writer = new Writer();
        String fileName = event.context().toString().replace(".dat", "");
        List<String> lines = reader.read(fileName);
        Metrics metrics = buildMetrics(lines);
        writer.writeOutputFile(metrics.toString(), fileName);
    }

    private static Metrics buildMetrics(List<String> fileLines) {
        MetricsService metrics = new MetricsService();
        Integer amountOfClients = metrics.getAmountOfClients(fileLines);
        Integer amountOfSalesman = metrics.getAmountOfSalesman(fileLines);
        String mostExpensiveSale = metrics.getMostExpensiveSale(fileLines);
        String worstSalesman = metrics.getWorstSalesman(fileLines);
        return new Metrics(amountOfClients, amountOfSalesman, mostExpensiveSale, worstSalesman);
    }
}
