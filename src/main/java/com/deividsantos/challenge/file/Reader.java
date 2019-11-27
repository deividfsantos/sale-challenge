package com.deividsantos.challenge.file;

import com.deividsantos.challenge.type.Extension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Reader extends FileBase {

    private static final Logger logger = LogManager.getLogger(Reader.class);

    public List<String> read(String fileName) {
        File flatFile = new File(FILE_PATH_INPUT + fileName + Extension.INPUT.get());
        try {
            return Files.readAllLines(flatFile.toPath());
        } catch (IOException e) {
            logger.error("There was an error reading file {}.", fileName, e);
            return new ArrayList<>();
        }
    }

    public Stream<Path> listAlreadyExistentFiles() {
        Path path = FileSystems.getDefault().getPath(FILE_PATH_INPUT);
        try {
            return Files.list(path);
        } catch (IOException e) {
            logger.error("An error occurred while listing existing files.", e);
            return Stream.empty();
        }
    }
}

