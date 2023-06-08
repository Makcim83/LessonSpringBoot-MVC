package ru.skyprolessons.spring.HomeWork1Spring.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static int employeeLastId;
    private static List<Employee> employeeList = new ArrayList<>();

    static {  //test
        addEmployeesForExample();
    }

    private static void addEmployeesForExample() {
        employeeList.add(new Employee(0, "Катя", 90000));
        employeeList.add(new Employee(1, "Дима", 102000));
        employeeList.add(new Employee(2, "Олег", 80000));
        employeeList.add(new Employee(3, "Вика", 125000));
        employeeLastId = 4;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = employeeList.stream()
                .filter(i -> i.getId() == id)
                .findAny()
                .orElse(new Employee(id, "no found", 0));
        return employee;
    }

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
