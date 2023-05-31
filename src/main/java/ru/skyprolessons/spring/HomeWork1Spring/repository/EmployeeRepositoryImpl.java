package ru.skyprolessons.spring.HomeWork1Spring.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {


    private final List<Employee> employeeList = List.of(
            new Employee("Катя", 90000),
            new Employee("Дима", 102000),
            new Employee("Олег", 80000),
            new Employee("Вика", 165000)
    );

    @Override
    public int getEmployeeCount() {
        return employeeList.size();
    }
}
