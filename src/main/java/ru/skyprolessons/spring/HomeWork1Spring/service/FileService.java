package ru.skyprolessons.spring.HomeWork1Spring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Service
public class FileService {

    private static ObjectMapper objectMapper;

    public static void addReportInFile(File file, Report report) throws IOException {
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