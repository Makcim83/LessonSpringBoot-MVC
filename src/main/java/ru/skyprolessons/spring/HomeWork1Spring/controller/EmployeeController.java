package ru.skyprolessons.spring.HomeWork1Spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;
import ru.skyprolessons.spring.HomeWork1Spring.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/starttest")
    public String startTest() {
        return employeeService.startTest();
    }

    @GetMapping("/count")
    public Long getEmployeeCount() {
        return employeeService.getEmployeeCount();
    }

    @GetMapping("/salary/sum")
    public int getEmployeeSalarySum() {
        return employeeService.getEmployeeSalarySum();
    }

    @GetMapping("/salary/min")
    public int getEmployeeSalaryMin() {
        return employeeService.getEmployeeSalaryMin();
    }

    @GetMapping("/salary/max")
    public int getEmployeeSalaryMax() {
        return employeeService.getEmployeeSalaryMax();
    }

    @GetMapping("/salary/high-salary")
    public List<Employee> getEmployeesSalaryHighSalary() {
        return employeeService.getEmployeesHighSalary();
    }

    @GetMapping(value = "/salaryHigherThan/{salary}")
    public List<Employee> getEmployeesWithSalaryMoreThan(@PathVariable int salary) {
        return employeeService.getEmployeesWithSalaryMoreThan(salary);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.getEmployeeByID(id));
    }

    @PostMapping("/new")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping("/edit/{id}")
    public void addEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.editEmployee(id, employee);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void removeEmployee(@PathVariable int id) {
        employeeService.removeEmployee(id);
    }
}