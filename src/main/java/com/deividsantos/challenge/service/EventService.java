package com.deividsantos.challenge.service;

import com.deividsantos.challenge.file.Reader;
import com.deividsantos.challenge.file.Watcher;
import com.deividsantos.challenge.file.Writer;
import com.deividsantos.challenge.model.Metrics;
import com.deividsantos.challenge.type.Extension;

import java.nio.file.WatchEvent;
import java.util.List;

public class EventService {

    private Writer writer;
    private Reader reader;
    private MetricsService metricsService;
    private static final String EMPTY_VALUE = "";

    public EventService() {
        this.writer = new Writer();
        this.reader = new Reader();
        this.metricsService = new MetricsService();
    }

    public void watch() {
        EventService eventService = new EventService();
        try {
            Watcher watcher = new Watcher();
            watcher.watch().forEach(eventService::process);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(WatchEvent event) {
        String fileName = getFileName(event);
        List<String> lines = reader.read(fileName);
        Metrics metrics = metricsService.getAll(lines);
        writer.writeOutputFile(metrics.toString(), fileName);
    }

    private String getFileName(WatchEvent event) {
        return event.context().toString().replace(Extension.INPUT.get(), EMPTY_VALUE);
    }

}
