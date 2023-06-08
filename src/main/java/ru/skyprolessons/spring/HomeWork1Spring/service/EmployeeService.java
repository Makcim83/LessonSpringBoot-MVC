package ru.skyprolessons.spring.HomeWork1Spring.service;

import org.springframework.web.bind.annotation.PathVariable;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;
import ru.skyprolessons.spring.HomeWork1Spring.repository.EmployeeRepository;

import java.util.List;

public interface EmployeeService {

    int getEmployeeCount();

    int getEmployeeSalarySum();

    int getEmployeeSalaryMin();

    int getEmployeeSalaryMax();

    List<Employee> getEmployeesHighSalary();

    List<Employee> getEmployeesWithSalaryMoreThan(int salary);

    Employee getEmployeeByID(int id);

    void addEmployee(Employee employee);

    void removeEmployee(int id);
}
