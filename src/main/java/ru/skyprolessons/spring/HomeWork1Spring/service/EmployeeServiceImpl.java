package ru.skyprolessons.spring.HomeWork1Spring.service;

import org.springframework.stereotype.Service;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;
import ru.skyprolessons.spring.HomeWork1Spring.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public String startTest() {
        employeeRepository.startTest();
        return employeeRepository.getEmployeeCount().toString();
    }

    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Long getEmployeeCount() {
        return employeeRepository.getEmployeeCount();
    }

    @Override
    public int getEmployeeSalarySum() {
        return employeeRepository.getEmployeeSalarySum();
    }

    @Override
    public int getEmployeeSalaryMin() {
        return employeeRepository.getEmployeeSalaryMin();
    }

    @Override
    public int getEmployeeSalaryMax() {
        return employeeRepository.getEmployeeSalaryMax();
    }

    @Override
    public List<Employee> getEmployeesHighSalary() {
        return employeeRepository.getEmployeesHighSalary();
    }

    @Override
    public List<Employee> getEmployeesWithSalaryMoreThan(int salary) {
        return employeeRepository.getEmployeesWithSalaryMoreThan(salary);
    }

    @Override
    public Optional<Employee> getEmployeeByID(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void editEmployee(int id, Employee employee) {
        employeeRepository.editEmployee(id, employee);
    }

    @Override
    public void removeEmployee(int id) {
        employeeRepository.removeEmployee(id);
    }
}