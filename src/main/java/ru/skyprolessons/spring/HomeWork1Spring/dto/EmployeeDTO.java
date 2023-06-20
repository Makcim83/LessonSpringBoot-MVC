package ru.skyprolessons.spring.HomeWork1Spring.dto;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;
@NoArgsConstructor
@Setter
@Getter
public class EmployeeDTO {
//    private Integer id;
    private String name;
    private Integer salary;


    public static EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        return employeeDTO;
    }

    public Employee toEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
//        employee.setId(this.getId());
        employee.setName(this.getName());
        employee.setSalary(this.getSalary());
        return employee;
    }
}
