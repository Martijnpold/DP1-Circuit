package com.mpolder.dp1.parse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader implements IReader {
    private File file;

    public FileReader(File file) {
        this.file = file;
    }

    public List<String> read() throws IOException {
        return Files.readAllLines(file.toPath()).stream()
                .filter(o -> !o.startsWith("#"))
                .map(o -> o.replace("\t", ""))
                .map(o -> o.replace(" ", ""))
                .map(o -> o.replace(";", ""))
                .filter(o -> o.length() > 0)
                .collect(Collectors.toList());
    }
}
