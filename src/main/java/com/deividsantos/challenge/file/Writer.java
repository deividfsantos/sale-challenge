package com.deividsantos.challenge.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.Collections;

public class Writer extends FileBase {

    public Writer() {
        super();
    }

    public void writeOutputFile(String lines, String fileName) {
        File flatFile = new File(homeDirectory + FILE_PATH_OUTPUT + fileName + ".done.dat");
        try {
            Files.write(flatFile.toPath(), Collections.singletonList(lines));
        } catch (NoSuchFileException exception) {
            createFile(fileName);
            try {
                Files.write(flatFile.toPath(), Collections.singletonList(lines));
            } catch (IOException e) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private void createFile(String fileName) {
        File flatFile = new File(homeDirectory + FILE_PATH_OUTPUT + fileName + ".done.dat");
        try {
            Files.createFile(flatFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
