package ru.skyprolessons.spring.HomeWork1Spring.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;
import ru.skyprolessons.spring.HomeWork1Spring.service.FileService;
import ru.skyprolessons.spring.HomeWork1Spring.service.ReportService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    private final FileService fileService;

    @GetMapping(value = "/{id}")
    public Optional<Report> getReportById(@PathVariable int id) {
        return reportService.getReportById(id);
    }

    @PostMapping(value = "/all")
    public List<Report> getDepartmentsReports() {
        return reportService.getDepartmentsReports();
    }

    @PostMapping(value = "/testReport")
    public Report addSomeReportsForTest() {
        return reportService.addSomeReportsForTest();
    }

    @PostMapping(value = "/tofile//{id}")
    public void addReportInFile(int id) throws IOException {
        fileService.addReportInFile(reportService.getReportById(id));
    }
}