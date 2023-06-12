package ru.skyprolessons.spring.HomeWork1Spring.repository;

import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;

import java.util.List;

public interface EmployeeRepository {

    Employee getEmployeeById(int id);

    int getEmployeeCount();

    int getEmployeeSalarySum();

    int getEmployeeSalaryMin();

    int getEmployeeSalaryMax();

    List<Employee> getEmployeesHighSalary();

    List<Employee> getEmployeesWithSalaryMoreThan(int salary);

    void addEmployee(Employee employee);

    void editEmployee(int id, Employee employee);

    void removeEmployee(int id);
}