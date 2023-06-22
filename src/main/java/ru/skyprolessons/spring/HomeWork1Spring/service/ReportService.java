package ru.skyprolessons.spring.HomeWork1Spring.service;

import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    Optional<Report> getReportById(int id);

    List<Report> getDepartmentsReports();

    Report addSomeReportsForTest();

    void addAllReportsInFile(int id);
}