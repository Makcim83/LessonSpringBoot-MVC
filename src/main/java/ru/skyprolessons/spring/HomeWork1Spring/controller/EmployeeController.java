package ru.skyprolessons.spring.HomeWork1Spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skyprolessons.spring.HomeWork1Spring.dto.EmployeeDTO;
import ru.skyprolessons.spring.HomeWork1Spring.dto.EmployeeFullInfo;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Employee;
import ru.skyprolessons.spring.HomeWork1Spring.service.EmployeeService;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/starttest")
    public String startTest() {
        return employeeService.startTest();
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/count")
    public Long getEmployeeCount() {
        return employeeService.getEmployeeCount();
    }

    @GetMapping("/salary/sum")
    public int getEmployeeSalarySum() {
        return employeeService.getEmployeeSalarySum();
    }

    @GetMapping("/salary/min")
    public int getEmployeeSalaryMin() {
        return employeeService.getEmployeeSalaryMin();
    }

    @GetMapping("/salary/max")
    public int getEmployeeSalaryMax() {
        return employeeService.getEmployeeSalaryMax();
    }

    @GetMapping("/salary/high-salary")
    public List<Employee> getEmployeesSalaryHighSalary() {
        return employeeService.getEmployeesHighSalary();
    }

    @GetMapping(value = "/salaryHigherThan/{salary}")
    public List<Employee> getEmployeesWithSalaryMoreThan(@PathVariable int salary) {
        return employeeService.getEmployeesWithSalaryMoreThan(salary);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.getEmployeeByID(id));
    }

    @PostMapping("/new")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping("/edit/{id}")
    public void addEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.editEmployee(id, employee);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }


    @GetMapping(value = "/withHighestSalary")
    public List<Employee> getEmployeesWithHighestSalary() {
        return employeeService.getEmployeesWithHighestSalary();
    }

    @GetMapping(value = "/fullinfo")
    public List<EmployeeFullInfo> findAllEmployeesFullInfo() {
        return employeeService.findAllEmployeesFullInfo();
    }

//    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public void uploadFile(@RequestParam("file") MultipartFile file) {
//        EmployeeDTO employeeDTO = null;
//        System.out.println("Размер файла: " + file.getSize() + " байт");
//        try (
//                FileInputStream fileInputStream = new FileInputStream(file);
//                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
//            employeeDTO = (EmployeeDTO) objectInputStream.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return file.getSize();
//    }



}