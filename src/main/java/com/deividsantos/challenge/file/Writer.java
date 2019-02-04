package com.deividsantos.challenge.file;

import com.deividsantos.challenge.type.Extension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

public class Writer extends FileBase {

    public void writeOutputFile(String line, String fileName) {
        File flatFile = new File(FILE_PATH_OUTPUT + fileName + Extension.OUTPUT.get());
        Path path = flatFile.toPath();
        write(line, path);
    }

    private void write(String lines, Path path) {
        try {
            Files.write(path, Collections.singletonList(lines));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
