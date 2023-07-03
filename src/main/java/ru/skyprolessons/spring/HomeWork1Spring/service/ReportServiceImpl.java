package ru.skyprolessons.spring.HomeWork1Spring.service;

import org.springframework.stereotype.Service;
import ru.skyprolessons.spring.HomeWork1Spring.dto.EmployeeFullInfo;
import ru.skyprolessons.spring.HomeWork1Spring.dto.ReportDTO;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;
import ru.skyprolessons.spring.HomeWork1Spring.repository.ReportRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

//    FileService fileService = new FileService();
    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Optional<Report> getReportById(int id) {
        Report report = null;

        return reportRepository.findById(id);
    }

    @Override
    public List<Report> getDepartmentsReports() {
        List<Report> result = new ArrayList<>();
        reportRepository.getDepartmentsReports().forEach(result::add);
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
    public void addReportToFile(int id) throws IOException {
        FileService fileService = new FileService();
        Report report = reportRepository
                .findById(id)
                .orElse(null);
        fileService.addReportInFile(report);
    }
//
//
//    ReportDTO reportDTO = null;
//        reportDTO.reportDTO(report);
//
//        try(
//    FileOutputStream fileOutputStream = new FileOutputStream(fileService.toString());
//    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
//
//    {
//
//        objectOutputStream.writeObject(reportDTO);
//    } catch(
//    IOException e)
//
//    {
//        e.printStackTrace();
//    }
//}
}
