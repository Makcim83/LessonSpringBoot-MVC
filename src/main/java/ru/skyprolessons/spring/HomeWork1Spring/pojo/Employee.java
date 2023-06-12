package ru.skyprolessons.spring.HomeWork1Spring.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Integer id;
    private final String name;
    private final int salary;
}