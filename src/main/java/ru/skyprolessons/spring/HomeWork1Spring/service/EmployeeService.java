package ru.skyprolessons.spring.HomeWork1Spring.service;

import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    int getEmployeeCount();

    int getEmployeeSalarySum();

    int getEmployeeSalaryMin();

    int getEmployeeSalaryMax();

    List<Employee> getEmployeeHighSalary();

    Employee getEmployeeByID(int id);
}
