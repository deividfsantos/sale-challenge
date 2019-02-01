package com.deividsantos.challenge.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.List;

public class Writer extends FileBase {

    private File flatFile;

    public Writer() {
        super();
        flatFile = new File(homeDirectory + FILE_PATH_OUTPUT+"test.dat");
    }

    public void writeOutputFile(List<String> lines) throws IOException {
        try {
            Files.write(flatFile.toPath(), lines);
        } catch (NoSuchFileException exception) {
            createFile();
            Files.write(flatFile.toPath(), lines);
        }
    }

    private void createFile() throws IOException {
        Files.createFile(flatFile.toPath());
    }
}
