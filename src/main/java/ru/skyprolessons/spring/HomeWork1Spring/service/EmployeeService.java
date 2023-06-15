package ru.skyprolessons.spring.HomeWork1Spring.service;

import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    String startTest();

    Long getEmployeeCount();

    List<Employee> getAllEmployees();

//    int getEmployeeSalarySum();
//
//    int getEmployeeSalaryMin();
//
//    int getEmployeeSalaryMax();
//
//    List<Employee> getEmployeesHighSalary();
//
//    List<Employee> getEmployeesWithSalaryMoreThan(int salary);
//
    Optional<Employee> getEmployeeByID(int id);

    void addEmployee(Employee employee);

    void editEmployee(int id, Employee employee);

    void removeEmployee(int id);
}
