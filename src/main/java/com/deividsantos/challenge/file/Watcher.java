package com.deividsantos.challenge.file;

import com.deividsantos.challenge.type.Extension;

import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardWatchEventKinds.*;

public class Watcher extends FileBase {

    private WatchKey watchKey;
    private WatchService watchService;
    private Path path;

    public Watcher() {
        defineDirectory();
    }

    private void defineDirectory() {
        try {
            path = FileSystems.getDefault().getPath(FILE_PATH_INPUT);
            watchService = path.getFileSystem().newWatchService();
            path.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
            watchKey = watchService.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<WatchEvent> watch() {
        return watchKey.pollEvents().stream()
                .filter(event -> event.context().toString().endsWith(Extension.INPUT.get()))
                .collect(Collectors.toList());
    }
}
