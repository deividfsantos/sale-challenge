package com.deividsantos.challenge;

import com.deividsantos.challenge.file.Reader;
import com.deividsantos.challenge.file.Watcher;
import com.deividsantos.challenge.service.Metrics;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Watcher watcher = new Watcher();
        Reader reader = new Reader();
        while (true) {
            List<WatchEvent<?>> events = watcher.watch();
            events.stream()
                    .map(event -> reader.read(event.context().toString()))
                    .forEach(Main::getMetrics);
        }
    }

    private static void getMetrics(List<String> fileLines) {
        Metrics metrics = new Metrics();
        System.out.println(metrics.getAmountOfClients(fileLines));
        System.out.println(metrics.getAmountOfSalesman(fileLines));
        System.out.println(metrics.getMostExpensiveSale(fileLines));
    }
}
