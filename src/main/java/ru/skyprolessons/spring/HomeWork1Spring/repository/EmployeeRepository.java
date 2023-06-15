package ru.skyprolessons.spring.HomeWork1Spring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}