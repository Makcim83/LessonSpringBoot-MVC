package ru.skyprolessons.spring.HomeWork1Spring.repository;

import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;

import java.util.List;
import java.util.OptionalInt;

public interface EmployeeRepository {
    int getEmployeeCount();

    int getEmployeeSalarySum();

    int getEmployeeSalaryMin();

    int getEmployeeSalaryMax();

    List<Employee> getEmployeeHighSalary();
}
