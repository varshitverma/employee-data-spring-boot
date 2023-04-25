package com.example.myproject.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.myproject.Repository.EmployeeRepository;
import com.example.myproject.error.EmployeeNotFoundException;
import com.example.myproject.model.Employee;

@Service
class EmployeeService implements EmployeeRepository {

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        if (employee.getEmployeeId() == null ||
            employee.getEmailId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) { 

        return employees.stream()
                        .filter(employee -> employee.getEmployeeId().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new EmployeeNotFoundException(
                            "Employee Id Not Found : " + id));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee = 
                employees.stream()
                         .filter(e -> e.getEmployeeId().equals(id))
                         .findFirst()
                         .get();
            employees.remove(employee);
        return "Employee Deleted with the id :" + id;
        }

}