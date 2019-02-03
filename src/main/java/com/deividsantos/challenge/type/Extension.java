package com.deividsantos.challenge.type;

public enum Extension {
    INPUT(".dat"),
    OUTPUT(".done.dat");

    private final String extension;

    Extension(String code) {
        this.extension = code;
    }

    public String get() {
        return extension;
    }
}
