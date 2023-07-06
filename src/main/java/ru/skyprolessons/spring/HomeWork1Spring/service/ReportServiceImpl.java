package ru.skyprolessons.spring.HomeWork1Spring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;
import ru.skyprolessons.spring.HomeWork1Spring.repository.ReportRepository;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Value("${path.fileforreports}")
    String pathFileForReports;
//    private File fileForReports = new File(new URI(pathFileForReports));
    private File fileForReports = new File("src/main/java/ru/skyprolessons/spring/homework1spring/files/json.txt");

    public ReportServiceImpl(ReportRepository reportRepository) throws URISyntaxException {
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

            FileService.addReportInFile(fileForReports, report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Report getReportFromFile() throws JsonProcessingException {

        String jsonString;
        jsonString = FileService.readTextFromFile(fileForReports);

        Report report = objectMapper.readValue(jsonString, Report.class);
        System.out.println(report);
        return report;
    }
}
