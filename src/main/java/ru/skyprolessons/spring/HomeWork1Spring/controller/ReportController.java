package ru.skyprolessons.spring.HomeWork1Spring.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;
import ru.skyprolessons.spring.HomeWork1Spring.service.ReportService;

import java.util.Optional;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping(value = "/{id}")
    public Optional<Report> getReportById(@PathVariable int id) {
//        return reportService.getReportById(id);
        return null;
    }

    @PostMapping(value = "/all")
    public Report getDepartmentsReport() {
//        return reportService.getDepartmentsReport();
        return null;
    }
}