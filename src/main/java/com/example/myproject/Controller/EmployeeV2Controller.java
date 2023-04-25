package com.example.myproject.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.Service.EmployeeV2Service;
import com.example.myproject.model.Employee;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeV2Controller {

    // @Qualifier("employeeV2RepositoryImpl")
    @Autowired
    private EmployeeV2Service employeeV2Service;

    @PostMapping()
    public Employee save(@RequestBody Employee employee) {
        return employeeV2Service.save(employee);
    }

    @GetMapping()
    public List<Employee> getEmployees() {
        return employeeV2Service.getEmployees();
    }

    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) {
        return employeeV2Service.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") String id) {
        return employeeV2Service.deleteEmployeeById(id);
    }

}
