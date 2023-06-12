package ru.skyprolessons.spring.HomeWork1Spring.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static int employeeLastId;
    private static List<Employee> employeeList = new ArrayList<>();

    {  //test
        addEmployeesForExample();
    }
    private void addEmployeesForExample() {
        save(new Employee(employeeLastId++, "Катя", 90000));
        save(new Employee(employeeLastId++, "Дима", 102000));
        save(new Employee(employeeLastId++, "Олег", 80000));
        save(new Employee(employeeLastId++, "Вика", 125000));
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        Optional<Employee> employee = findById(id);
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
    public List<Employee> getEmployeesHighSalary() {
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

    @Override
    public List<Employee> getEmployeesWithSalaryMoreThan(int salary) {
        List<Employee> employeesWithSalaryMoreThan = employeeList
                .stream()
                .filter(i -> i.getSalary() > salary)
                .collect(Collectors.toList());
        return employeesWithSalaryMoreThan;
    }

    public void addEmployee(Employee employee) {
            save(employee);
    }

    @Override
    public void editEmployee(int id, Employee employee) {
        Long count = employeeList.stream()
                .filter(i -> i.getId() == id)
                .count();
        if (count > 0) {
            employeeList.remove(getEmployeeById(id));
            employeeList.add(new Employee(id, employee.getName(), employee.getSalary()));
        }
    }

    @Override
    public void removeEmployee(int id) {
        Long count = employeeList.stream()
                .filter(i -> i.getId() == id)
                .count();
        if (count > 0) {
            employeeList.remove(getEmployeeById(id));
        }
    }

    @Override
    public <S extends Employee> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Employee> findAll() {
        return null;
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Employee entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {

    }

    @Override
    public void deleteAll() {

    }
}