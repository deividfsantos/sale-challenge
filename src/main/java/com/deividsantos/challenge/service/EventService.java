package com.deividsantos.challenge.service;

import com.deividsantos.challenge.file.Reader;
import com.deividsantos.challenge.file.Watcher;
import com.deividsantos.challenge.file.Writer;
import com.deividsantos.challenge.model.Metrics;
import com.deividsantos.challenge.type.Extension;

import java.nio.file.WatchEvent;
import java.util.List;

public class EventService {

    private static Writer writer = new Writer();
    private static Reader reader = new Reader();
    private static Watcher watcher = new Watcher();
    private static MetricsService metricsService = new MetricsService();
    private static final String EMPTY_VALUE = "";

    public static void watch() {
        try {
            List<WatchEvent> events = watcher.watch();
            events.forEach(EventService::process);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void process(WatchEvent event) {
        String fileName = getFileNameWithoutExtension(event);
        List<String> lines = reader.read(fileName);
        String metrics = metricsService.getMetrics(lines);
        writer.writeOutputFile(metrics, fileName);
    }

    private static String getFileNameWithoutExtension(WatchEvent event) {
        return event.context().toString().replace(Extension.INPUT.get(), EMPTY_VALUE);
    }

}
