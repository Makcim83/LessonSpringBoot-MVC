package ru.skyprolessons.spring.HomeWork1Spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skyprolessons.spring.HomeWork1Spring.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("/count")
    public int getEmployeeCount() {
        return employeeService.getEmployeeCount();
    }


}