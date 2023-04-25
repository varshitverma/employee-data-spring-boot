package com.example.myproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.Repository.EmployeeRepository;
import com.example.myproject.model.Employee;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    @Qualifier("employeeService")
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping()
    public Employee save(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping()
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) {
        return employeeRepository.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") String id) {
        return employeeRepository.deleteEmployeeById(id);
    }

}
