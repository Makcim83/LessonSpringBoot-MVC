package ru.skyprolessons.spring.HomeWork1Spring.service;

import org.springframework.stereotype.Service;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;
import ru.skyprolessons.spring.HomeWork1Spring.repository.ReportRepository;

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
        reportRepository.getDepartmentsReports().forEach(result::add);
        return result;
    }

    @Override
    public Report addSomeReportsForTest() {
        return reportRepository.save(new Report(2, 2, 3, 4, 5));
    }

    @Override
    public void addAllReportsInFile(int id) {
    }
}
