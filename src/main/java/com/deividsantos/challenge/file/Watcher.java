package com.deividsantos.challenge.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class Watcher extends FileBase {

    private static final Logger logger = LogManager.getLogger(Watcher.class);

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
            path.register(watchService, ENTRY_CREATE, ENTRY_MODIFY);
            watchKey = watchService.take();
        } catch (Exception e) {
            logger.error("An error occurred while setting the file directory.", e);
        }
    }

    public List<WatchEvent<?>> watchEvents() {
        return watchKey.pollEvents();
    }
}
