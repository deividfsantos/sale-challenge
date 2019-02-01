package com.deividsantos.challenge.file;

import com.deividsantos.challenge.service.Constructor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class Watcher {

    private Reader reader;
    private Constructor constructor;

    public Watcher() {
        this.reader = new Reader();
        this.constructor = new Constructor();
    }

    public String teste() throws IOException, InterruptedException {
        Path path = FileSystems.getDefault().getPath(System.getProperty("user.home"), "/data/in/");
        WatchService watcher = path.getFileSystem().newWatchService();
        path.register(watcher, ENTRY_CREATE, ENTRY_MODIFY);
        WatchKey watckKey = watcher.take();

        while (true) {
            List<String> lines = watckKey.pollEvents().stream()
                    .filter(event -> event.context().toString().endsWith(".dat"))
                    .map(event -> reader.read(event.context().toString()))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
            constructor.modelsConstructors(lines);
        }
    }
}
