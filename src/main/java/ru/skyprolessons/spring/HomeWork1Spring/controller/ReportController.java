package ru.skyprolessons.spring.HomeWork1Spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;
import ru.skyprolessons.spring.HomeWork1Spring.service.ReportService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping(value = "/{id}")
    public Optional<Report> getReportById(@PathVariable int id) {
        return reportService.getReportById(id);
    }

    @PostMapping(value = "/all")
    public List<Report> getDepartmentsReports() {
        return reportService.getDepartmentsReports();
    }

    @PostMapping(value = "/testReport")
    public void addSomeReportsForTest() {
        reportService.addSomeReportsForTest();
    }

    @PostMapping(value = "/tofile/{id}")
    public void addReportInFile(@PathVariable int id) throws IOException {
        reportService.addReportToFile(id);
    }

    @GetMapping(value = "/fromfile")
    public Report getReportFromFile() throws JsonProcessingException {
        return reportService.getReportFromFile();
    }
}