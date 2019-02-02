package com.deividsantos.challenge.service;

import com.deividsantos.challenge.file.Reader;
import com.deividsantos.challenge.file.Writer;
import com.deividsantos.challenge.model.Metrics;
import com.deividsantos.challenge.type.Extension;

import java.nio.file.WatchEvent;
import java.util.List;

public class EventService {

    private Writer writer;
    private Reader reader;
    private MetricsService metricsService;

    public EventService() {
        this.writer = new Writer();
        this.reader = new Reader();
        this.metricsService = new MetricsService();
    }

    public void process(WatchEvent event) {
        String modifiedFileName = getFileName(event);
        List<String> lines = reader.read(modifiedFileName);
        Metrics metrics = metricsService.getAll(lines);
        writer.writeOutputFile(metrics.toString(), modifiedFileName);
    }

    private String getFileName(WatchEvent event) {
        return event.context().toString().replace(Extension.INPUT.get(), "");
    }

}
