package ru.skyprolessons.spring.HomeWork1Spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skyprolessons.spring.HomeWork1Spring.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public int getEmployeeCount() {
        return employeeRepository.getEmployeeCount();
    }


}