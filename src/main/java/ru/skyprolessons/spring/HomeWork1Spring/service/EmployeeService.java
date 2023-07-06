package ru.skyprolessons.spring.HomeWork1Spring.service;

import ru.skyprolessons.spring.HomeWork1Spring.dto.EmployeeDTO;
import ru.skyprolessons.spring.HomeWork1Spring.dto.EmployeeFullInfo;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    String startTest();

    Integer getEmployeeCount();

    List<EmployeeDTO> getAllEmployees();

    int getEmployeeSalarySum();

    int getEmployeeSalaryMin();

    int getEmployeeSalaryMax();

    List<Employee> getEmployeesHighSalary();

    List<Employee> getEmployeesWithSalaryMoreThan(int salary);

    Optional<Employee> getEmployeeByID(int id);

    void addEmployee(Employee employee);

    void editEmployee(int id, Employee employee);

    void deleteEmployee(int id);

    List<Employee> getEmployeesWithHighestSalary();

    List<EmployeeFullInfo> findAllEmployeesFullInfo();

    Report getCurrentReport();
}
