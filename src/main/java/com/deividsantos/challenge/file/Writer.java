package com.deividsantos.challenge.file;

import com.deividsantos.challenge.type.Extension;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

public class Writer extends FileBase {

    public void writeOutputFile(String line, String fileName) {
        File flatFile = new File(FILE_PATH_OUTPUT + fileName + Extension.OUTPUT.get());
        Path path = flatFile.toPath();
        try {
            createFile(flatFile);
            write(line, path);
        } catch (FileAlreadyExistsException e) {
            write(line, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createFile(File flatFile) throws IOException {
        Files.createFile(flatFile.toPath());
    }

    private void write(String lines, Path path) {
        try {
            Files.write(path, Collections.singletonList(lines));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
