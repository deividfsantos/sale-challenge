package com.deividsantos.challenge.file;

import com.deividsantos.challenge.type.Extension;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Reader extends FileBase {

    public List<String> read(String fileName) {
        File flatFile = new File(FILE_PATH_INPUT + fileName + Extension.INPUT.get());
        try {
            return Files.readAllLines(flatFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Stream<Path> listAlreadyExistentFiles() {
        Path path = FileSystems.getDefault().getPath(FILE_PATH_INPUT);
        try {
            return Files.list(path);
        } catch (IOException e) {
            e.printStackTrace();
            return Stream.empty();
        }
    }
}

