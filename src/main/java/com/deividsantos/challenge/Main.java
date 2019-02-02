package com.deividsantos.challenge;

import com.deividsantos.challenge.file.Watcher;
import com.deividsantos.challenge.service.SalesService;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Watcher watcher = new Watcher();
        SalesService salesService = new SalesService();
        while (true) {
            List<WatchEvent> events = watcher.watch();
            events.forEach(salesService::readEvent);
        }
    }
}
