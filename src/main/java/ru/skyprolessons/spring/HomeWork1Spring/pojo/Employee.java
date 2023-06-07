package ru.skyprolessons.spring.HomeWork1Spring.pojo;

import lombok.Data;
import ru.skyprolessons.spring.HomeWork1Spring.repository.EmployeeRepository;

@Data
public class Employee {

    private final Integer id;
    private final String name;
    private final int salary;
}