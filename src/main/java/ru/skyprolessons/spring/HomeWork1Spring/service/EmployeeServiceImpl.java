package ru.skyprolessons.spring.HomeWork1Spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;
import ru.skyprolessons.spring.HomeWork1Spring.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public int getEmployeeCount() {
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
    public Employee getEmployeeByID(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void removeEmployee(int id) {
        employeeRepository.removeEmployee(id);
    }
}