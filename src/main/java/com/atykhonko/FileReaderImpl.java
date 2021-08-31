package com.atykhonko;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReader {
    @Override
    public String[] readFileToArray(String pathToTheFile) {
        List<String> parseFileToLines = new ArrayList<>();
        if (isValidPath(pathToTheFile)) {
            try (Stream<String> stream = Files.lines(Paths.get(pathToTheFile))) {
                parseFileToLines = stream.collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("File not found!");
        }
        if (parseFileToLines.isEmpty()) {
            throw new IllegalArgumentException("File is empty!");
        }
        String[] result = new String[parseFileToLines.size()];
        result = parseFileToLines.toArray(result);
        return result;
    }

    private boolean isValidPath(String path) {
        if (path == null) {
            return false;
        }
        File fileChecker = new File(path);
        return fileChecker.exists() && fileChecker.isFile();
    }
}
