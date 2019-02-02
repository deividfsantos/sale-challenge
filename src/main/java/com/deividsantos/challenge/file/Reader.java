package com.deividsantos.challenge.file;

import com.deividsantos.challenge.type.Extension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Reader extends FileBase {

    public List<String> read(String fileName) {
        File flatFile = new File(FILE_PATH_INPUT + fileName + Extension.INPUT.get());
        try {
            return Files.readAllLines(flatFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}

