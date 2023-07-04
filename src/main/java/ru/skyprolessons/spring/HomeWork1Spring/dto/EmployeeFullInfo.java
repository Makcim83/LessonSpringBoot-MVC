package ru.skyprolessons.spring.HomeWork1Spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Position;

@Getter
@NoArgsConstructor
public class EmployeeFullInfo {
    private String name;
    private Integer salary;
    private Position position;
    private String namePosition;

    public EmployeeFullInfo(String name, Integer salary, String namePosition) {
        this.name = name;
        this.salary = salary;
        this.namePosition = namePosition;
    }

    public static EmployeeFullInfo fromEmployee(Employee employee) {
        EmployeeFullInfo employeeFullInfo = new EmployeeFullInfo();
        employeeFullInfo.setName(employee.getName());
        employeeFullInfo.setSalary(employee.getSalary());
        employeeFullInfo.setNamePosition(employee.getPosition().getNamePosition());
        return employeeFullInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = position.getNamePosition();
    }
}