package ru.skyprolessons.spring.HomeWork1Spring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;
import ru.skyprolessons.spring.HomeWork1Spring.repository.ReportRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Optional<Report> getReportById(int id) {
        return reportRepository.findById(id);
    }

    @Override
    public List<Report> getDepartmentsReports() {
        List<Report> result = new ArrayList<>();
        reportRepository
                .getDepartmentsReports()
                .forEach(result::add);
        return result;
    }

    @Override
    public void addSomeReportsForTest() {
        reportRepository.save(new Report(1, "1", 1, 1, 1, 1));
    }

    @Override
    public void addAllReportsInFile(int id) {
    }

    @Override
    public void addReportToFile(int id) {
        Report report = reportRepository
                .findById(id)
                .orElse(null);
        try {
            File file = new File("src/main/java/ru/skyprolessons/spring/homework1spring/files/json.txt");
            FileService.addReportInFile(file, report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Report getReportFromFile() throws JsonProcessingException {
        File file = new File("src/main/java/ru/skyprolessons/spring/homework1spring/files/json.txt");
        String jsonString;
        jsonString = FileService.readTextFromFile(file);

        ObjectMapper objectMapper = new ObjectMapper();
        Report report = objectMapper.readValue(jsonString, Report.class);
        System.out.println(report);
        return report;
    }
}
