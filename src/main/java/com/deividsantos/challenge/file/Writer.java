package com.deividsantos.challenge.file;

import com.deividsantos.challenge.type.Extension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Collections;

public class Writer extends FileBase {

    private static final Logger logger = LogManager.getLogger(Writer.class);

    public void writeOutputFile(String line, String fileName) {
        File flatFile = new File(FILE_PATH_OUTPUT + fileName + Extension.OUTPUT.get());
        Path path = flatFile.toPath();
        write(line, path);
    }

    private void write(String lines, Path path) {
        try {
            Files.write(path, Collections.singletonList(lines));
        } catch (NoSuchFileException e) {
            createAndWriteFile(lines, path);
        } catch (IOException e) {
            logger.error("An error occurred while writing output file.", e);
        }
    }

    private void createAndWriteFile(String lines, Path path) {
        try {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
            Files.write(path, Collections.singletonList(lines));
        } catch (IOException e) {
            logger.error("An error occurred while creating and writing output file.", e);
        }
    }
}
