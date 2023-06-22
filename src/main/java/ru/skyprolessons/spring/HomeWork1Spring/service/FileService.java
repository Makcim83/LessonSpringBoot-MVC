package ru.skyprolessons.spring.HomeWork1Spring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.Optional;

public class FileService {
    final File file = new File("json.txt");
    public void addReportInFile(Optional<Report> report) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file , report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
