package ru.skyprolessons.spring.HomeWork1Spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.skyprolessons.spring.HomeWork1Spring.dto.EmployeeFullInfo;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("SELECT new ru.skyprolessons.spring.HomeWork1Spring.dto." +
            "EmployeeFullInfo(e.name, e.salary, p.namePosition) " +
            "FROM Employee e join fetch Position p " +
            "WHERE e.position = p.namePosition")
    List<Employee> findAllEmployeesFullInfo();

    @Query(value = "SELECT SUM (salary) FROM Employee", nativeQuery = false)
    int getEmployeeSalarySum();

    @Query(value = "SELECT MIN (salary) FROM Employee", nativeQuery = true)
    int getEmployeeSalaryMin();

    @Query(value = "SELECT MAX (salary) FROM Employee", nativeQuery = true)
    int getEmployeeSalaryMax();

    @Query(value = "SELECT name, salary, " +
            "FROM Employee e " +
            "JOIN FETCH Position p ON e.position = p.positionname" +
            "WHERE salary > ( " +
            "SELECT AVG(salary) " +
            "FROM Employee ) " +
            "ORDER BY salary DESC ", nativeQuery = true)
    List<Employee> getEmployeesHighSalary();

    @Query(value = "SELECT * FROM employee e LEFT OUTER JOIN positioon p WHERE e.salary > ?1 ", nativeQuery = true)
    List<Employee> getEmployeesWithSalaryMoreThan(int salaryForCompare);

    @Query(value = "SELECT a FROM Employee e LEFT OUTER JOIN Position p WHERE e.salary = (SELECT MAX(e.salary) FROM employee e) ", nativeQuery = true)
    List<Employee> getEmployeesWithHighestSalary();
}