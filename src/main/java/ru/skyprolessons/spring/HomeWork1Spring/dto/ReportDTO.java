package ru.skyprolessons.spring.HomeWork1Spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;

import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
public class ReportDTO implements Serializable {
    private String departmentName;
    private Integer countEmployees;
    private Integer maxSalary;
    private Integer minSalary;
    private Integer avgSalary;

    public ReportDTO(String departmentName,
                     Integer countEmployees,
                     Integer maxSalary,
                     Integer minSalary,
                     Integer avgSalary) {
        this.departmentName = departmentName;
        this.countEmployees = countEmployees;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.avgSalary = avgSalary;
    }

    public ReportDTO reportDTO(Report report) {
        ReportDTO reportDTO = new ReportDTO();
//        reportDTO.setDepartmentName(report.getDepartmentName());
        reportDTO.setCountEmployees(report.getCountEmployees());
        reportDTO.setMaxSalary(report.getMaxSalary());
        reportDTO.setMinSalary(report.getMinSalary());
        reportDTO.setAvgSalary(report.getAvgSalary());
        return reportDTO;
    }

    public Report report(ReportDTO reportDTO) {
        Report report = new Report();
//        report.setDepartmentName(reportDTO.getDepartmentName());
        report.setCountEmployees(reportDTO.getCountEmployees());
        report.setMaxSalary(reportDTO.getMaxSalary());
        report.setMinSalary(reportDTO.getMinSalary());
        report.setAvgSalary(report.getAvgSalary());
        return report;
    }
}