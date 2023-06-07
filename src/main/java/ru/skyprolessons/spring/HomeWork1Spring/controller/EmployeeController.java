package ru.skyprolessons.spring.HomeWork1Spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;
import ru.skyprolessons.spring.HomeWork1Spring.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("/count")
    public int getEmployeeCount() {
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
    public List<Employee> getEmployeeSalaryHighSalary() {
        return employeeService.getEmployeeHighSalary();
    }

//    @GetMapping
//        Employee getEmployeeByID(@RequestParam Map <String, String> params) {
//        int id = Integer.parseInt(params.get("id"));
//        String name = params.get("name");
//        int salary = 125000;
//
//        return new Employee(id, name, salary);
//    }

    @GetMapping("/id/{id}")
    Employee getEmployeeByID(@RequestParam String idFromPath) {
        int id = Integer.parseInt(idFromPath);
        Employee employee = employeeService.getEmployeeByID(id);
        return employee;
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
    }
}