package ru.skyprolessons.spring.HomeWork1Spring.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;
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

//    @GetMapping(value = "/{id}")
//    public Optional<Report> getReportById(@PathVariable int id) {
//        return reportService.getReportById(id);
//    }
//
//    @PostMapping(value = "/all")
//    public List<Report> getDepartmentsReports() {
//        return reportService.getDepartmentsReports();
//    }
//
    @PostMapping(value = "/testReport")
    public void addSomeReportsForTest() {
        reportService.addSomeReportsForTest();
    }

    @PostMapping(value = "/tofile/{id}")
    public void addReportInFile(@PathVariable int id) throws IOException {
        reportService.addReportToFile(id);
    }

    //    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public void uploadFile(@RequestParam("file") MultipartFile file) {
//        EmployeeDTO employeeDTO = null;
//        System.out.println("Размер файла: " + file.getSize() + " байт");
//        try (
//                FileInputStream fileInputStream = new FileInputStream(file);
//                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
//            employeeDTO = (EmployeeDTO) objectInputStream.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return file.getSize();
//    }


}