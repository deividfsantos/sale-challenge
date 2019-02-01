package com.deividsantos.challenge.file;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardWatchEventKinds.*;

public class Watcher extends FileBase {

    private WatchKey watchKey;
    private WatchService watcher;
    private Path path;

    public Watcher() throws IOException, InterruptedException {
        path = FileSystems.getDefault().getPath(FILE_PATH_INPUT);
        watcher = path.getFileSystem().newWatchService();
        path.register(watcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
        watchKey = watcher.take();
    }

    public List<WatchEvent> watch() {
        return watchKey.pollEvents().stream()
                .filter(event -> event.context().toString().endsWith(EXTENSION_INPUT))
                .collect(Collectors.toList());
    }
}
