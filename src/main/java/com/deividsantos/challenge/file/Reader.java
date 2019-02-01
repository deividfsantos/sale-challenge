package com.deividsantos.challenge.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Reader extends FileBase {

    public Reader() {
        super();
    }

    public List<String> read(String file) {
        File flatFile = new File(homeDirectory + FILE_PATH_INPUT + file);
        try {
            return Files.readAllLines(flatFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}

