package ru.skyprolessons.spring.HomeWork1Spring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    Optional<Report> getReportById(int id);

    List<Report> getDepartmentsReports();

    void addSomeReportsForTest();

    void addAllReportsInFile(int id);

    void addReportToFile(int id);

    Report getReportFromFile() throws JsonProcessingException;
}