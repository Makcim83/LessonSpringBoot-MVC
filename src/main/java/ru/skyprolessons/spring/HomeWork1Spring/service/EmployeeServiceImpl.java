package ru.skyprolessons.spring.HomeWork1Spring.service;

import org.springframework.stereotype.Service;
import ru.skyprolessons.spring.HomeWork1Spring.dto.EmployeeDTO;
import ru.skyprolessons.spring.HomeWork1Spring.dto.EmployeeFullInfo;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Position;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Report;
import ru.skyprolessons.spring.HomeWork1Spring.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String startTest() {
        System.out.println("test - service class /add some employees/");
        employeeRepository.save(new Employee(1, "Катя", 90000, new Position(1, "pos1")));
        employeeRepository.save(new Employee(2, "Дима", 102000, new Position(1, "pos1")));
        employeeRepository.save(new Employee(3, "Олег", 80000, new Position(2, "pos2")));
        employeeRepository.save(new Employee(4, "Вика", 125000, new Position(3, "pos3")));
        return "test";
    }

    @Override
    public Integer getEmployeeCount() {
        return Math.toIntExact(employeeRepository.count());
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> result = new ArrayList<>();
        employeeRepository.findAll().forEach(result::add);

        return result.stream()
                .map(EmployeeDTO::fromEmployee)
                .toList();
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
        return employeeRepository.findById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void editEmployee(int id, Employee employee) {
        Optional<Employee> e = employeeRepository.findById(id);
        if (e.isEmpty()) {
            employeeRepository.save(employee);
        } else {
            System.out.println("cant edit id = " + id + " (no found)");
        }
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesWithHighestSalary() {
        return employeeRepository.getEmployeesWithHighestSalary();
    }

    public List<EmployeeFullInfo> findAllEmployeesFullInfo() {
        List<Employee> result = new ArrayList<>();
        employeeRepository.findAllEmployeesFullInfo().forEach(result::add);
        return result.stream()
                .map(EmployeeFullInfo::fromEmployee)
                .toList();
    }

    public Report getCurrentReport() {
        Report report = new Report();

        report.setDepartmentName("departmentName");
        report.setMaxSalary(getEmployeeSalaryMax());
        report.setMinSalary(getEmployeeSalaryMin());
        Integer count = getEmployeeCount();
        report.setCountEmployees(count);
        report.setAvgSalary((int) (getEmployeeSalarySum() / count));

        return report;
    }
}