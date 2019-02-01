package com.deividsantos.challenge.file;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class Watcher {

    private Reader reader;
    private Path path;
    private WatchService watcher;
    private WatchKey watchKey;

    public Watcher() throws IOException, InterruptedException {
        this.reader = new Reader();
        path = FileSystems.getDefault().getPath(System.getProperty("user.home"), "/data/in/");
        watcher = path.getFileSystem().newWatchService();
        path.register(watcher, ENTRY_CREATE, ENTRY_MODIFY);
        watchKey = watcher.take();
    }

    public List<WatchEvent<?>> watch() {
        return watchKey.pollEvents().stream()
                .filter(event -> event.context().toString().endsWith(".dat"))
                .filter(event -> event.kind().equals(ENTRY_MODIFY))
                .collect(Collectors.toList());
    }
}
