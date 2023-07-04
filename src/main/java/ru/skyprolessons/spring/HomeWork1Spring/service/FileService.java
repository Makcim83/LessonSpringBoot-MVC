package ru.skyprolessons.spring.HomeWork1Spring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileService {
    public static void addReportInFile(File file, Report report) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readTextFromFile(File file) {
        String result = null;
        try {
            Path path = Paths.get(file.getPath());
            result = Files.lines(path)
                    .collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
