package com.deividsantos.challenge.service;

import com.deividsantos.challenge.file.Reader;
import com.deividsantos.challenge.file.Writer;
import com.deividsantos.challenge.model.Metrics;
import com.deividsantos.challenge.parser.CustomerParser;
import com.deividsantos.challenge.parser.SaleParser;
import com.deividsantos.challenge.parser.SalesmanParser;
import com.deividsantos.challenge.type.Extension;

import java.nio.file.WatchEvent;
import java.util.List;

public class EventService {

    private Writer writer;
    private Reader reader;

    public EventService() {
        this.writer = new Writer();
        this.reader = new Reader();
    }

    public void process(WatchEvent event) {
        String modifiedFileName = getFileName(event);
        List<String> lines = reader.read(modifiedFileName);
        Metrics metrics = buildMetrics(lines);
        writer.writeOutputFile(metrics.toString(), modifiedFileName);
    }

    private String getFileName(WatchEvent event) {
        return event.context().toString().replace(Extension.INPUT.get(), "");
    }

    private Metrics buildMetrics(List<String> lines) {
        return new MetricsService(CustomerParser.take(lines),
                SalesmanParser.take(lines),
                SaleParser.take(lines))
                .getAll();
    }

}
