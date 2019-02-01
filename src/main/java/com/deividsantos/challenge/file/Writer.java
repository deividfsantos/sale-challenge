package com.deividsantos.challenge.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Collections;

public class Writer extends FileBase {

    public void writeOutputFile(String line, String fileName) {
        File flatFile = new File(FILE_PATH_OUTPUT + fileName + EXTENSION_OUTPUT);
        Path path = flatFile.toPath();
        try {
            Files.write(path, Collections.singletonList(line));
        } catch (NoSuchFileException e) {
            createFile(flatFile);
            write(line, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void write(String lines, Path path) {
        try {
            Files.write(path, Collections.singletonList(lines));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFile(File file) {
        try {
            Files.createFile(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
