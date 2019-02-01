package com.deividsantos.challenge.file;

class FileBase {

    String homeDirectory;
    static final String FILE_PATH_INPUT = "/data/in/";
    static final String FILE_PATH_OUTPUT = "/data/out/";

    public FileBase() {
        this.homeDirectory = System.getProperty("user.home");
    }

}
