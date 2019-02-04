package com.deividsantos.challenge.service;

import com.deividsantos.challenge.file.Reader;
import com.deividsantos.challenge.file.Watcher;
import com.deividsantos.challenge.file.Writer;
import com.deividsantos.challenge.type.Extension;

import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.util.List;

public class EventService {

    private static Writer writer = new Writer();
    private static Reader reader = new Reader();
    private static MetricsService metricsService = new MetricsService();
    private static final String EMPTY_VALUE = "";

    public static void watchAlreadyExistentFiles() {
        reader.listAlreadyExistentFiles()
                .map(Path::getFileName)
                .map(Path::toString)
                .filter(EventService::isCorrectExtension)
                .map(EventService::getFileNameWithoutExtension)
                .forEach(EventService::process);
    }

    public static void watchModifications() {
        new Watcher().watchEvents().stream()
                .map(WatchEvent::context)
                .map(Object::toString)
                .filter(EventService::isCorrectExtension)
                .map(EventService::getFileNameWithoutExtension)
                .forEach(EventService::process);
    }

    private static void process(String fileName) {
        List<String> lines = reader.read(fileName);
        String metrics = metricsService.getMetrics(lines);
        writer.writeOutputFile(metrics, fileName);
    }

    private static boolean isCorrectExtension(String file) {
        return file.endsWith(Extension.INPUT.get());
    }

    private static String getFileNameWithoutExtension(String fullFilename) {
        return fullFilename.replace(Extension.INPUT.get(), EMPTY_VALUE);
    }
}
