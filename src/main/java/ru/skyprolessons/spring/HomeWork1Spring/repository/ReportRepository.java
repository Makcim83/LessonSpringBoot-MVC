package ru.skyprolessons.spring.HomeWork1Spring.repository;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;

import java.util.ArrayList;
import java.util.List;

public interface ReportRepository extends CrudRepository<Report, Integer> {

    @Query(value = "select * from report", nativeQuery = true)
    List<Report> getDepartmentsReports();
}
