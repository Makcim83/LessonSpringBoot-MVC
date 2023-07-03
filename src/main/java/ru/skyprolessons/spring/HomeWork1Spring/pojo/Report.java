package ru.skyprolessons.spring.HomeWork1Spring.pojo;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "report")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idReport;
    @Column(name = "departmentname")
    private String departmentName;
    @Column(name = "countemployees")
    private Integer countEmployees;
    @Column(name = "maxsalary")
    private Integer maxSalary;
    @Column(name = "minsalary")
    private Integer minSalary;
    @Column(name = "avgsalary")
    private Integer avgSalary;
}