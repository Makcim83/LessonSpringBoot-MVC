package ru.skyprolessons.spring.HomeWork1Spring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Optional<Employee> getEmployeeById(int id);

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