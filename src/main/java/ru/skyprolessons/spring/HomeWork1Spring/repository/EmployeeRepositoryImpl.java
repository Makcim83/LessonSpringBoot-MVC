package ru.skyprolessons.spring.HomeWork1Spring.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {


    private final List<Employee> employeeList = List.of(
            new Employee("Катя", 90000),
            new Employee("Дима", 102000),
            new Employee("Олег", 80000),
            new Employee("Вика", 125000)
    );

    @Override
    public int getEmployeeCount() {
        return employeeList.size();
    }

    @Override
    public int getEmployeeSalarySum() {
        int salarySum = employeeList
                .stream()
                .mapToInt(i -> i.getSalary())
                .sum();
        return salarySum;
    }

    @Override
    public int getEmployeeSalaryMin() {
        int salaryMin = employeeList
                .stream()
                .mapToInt(i -> i.getSalary())
                .min()
                .orElse(0);
        return (Integer) salaryMin;
    }

    @Override
    public int getEmployeeSalaryMax() {
        int salaryMax = employeeList
                .stream()
                .mapToInt(i -> i.getSalary())
                .sum();
        return salaryMax;
    }

    @Override
    public List<Employee> getEmployeeHighSalary() {
        //foreach with salary more than average
        int averageSalary;
        if (getEmployeeCount() == 0) {
            averageSalary = 0;
        } else {
            averageSalary = getEmployeeSalarySum() / getEmployeeCount();
        }
        List<Employee> employeeHihgSalary = employeeList
                .stream()
                .filter(employee -> employee.getSalary() > averageSalary)
                .collect(Collectors.toList());
        return employeeHihgSalary;
    }
}
