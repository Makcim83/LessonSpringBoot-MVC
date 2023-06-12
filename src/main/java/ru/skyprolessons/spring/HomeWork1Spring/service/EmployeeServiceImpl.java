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
        addEmployee(new Employee(1, "Катя", 90000));
        addEmployee(new Employee(2, "Дима", 102000));
        addEmployee(new Employee(3, "Олег", 80000));
        addEmployee(new Employee(4, "Вика", 125000));
        return "test block is started";
    }

    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Long getEmployeeCount() {
        return employeeRepository.count();
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
        employeeRepository.save(employee);
    }

    @Override
    public void editEmployee(int id, Employee employee) {
        employeeRepository.editEmployee(id, employee);
    }

    @Override
    public void removeEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}