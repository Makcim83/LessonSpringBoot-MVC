package ru.skyprolessons.spring.HomeWork1Spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query(value = "SELECT SUM (salary) FROM Employee", nativeQuery = true)
    int getEmployeeSalarySum();

    @Query(value = "SELECT MIN (salary) FROM Employee", nativeQuery = true)
    int getEmployeeSalaryMin();

    @Query(value = "SELECT MAX (salary) FROM Employee", nativeQuery = true)
    int getEmployeeSalaryMax();

    @Query(value = "SELECT * FROM employee e WHERE salary > (SELECT avg(salary) FROM employee e)", nativeQuery = true)
    List<Employee> getEmployeesHighSalary();

    @Query(value = "SELECT * FROM employee e WHERE salary > (salryForCompare)", nativeQuery = true)
    List<Employee> getEmployeesWithSalaryMoreThan(int salaryForCompare);

    @Query(value = "SELECT * FROM employee e WHERE salary = (SELECT MAX(salary) FROM employee e)", nativeQuery = true)
    List<Employee> getEmployeesWithHighestSalary();
}