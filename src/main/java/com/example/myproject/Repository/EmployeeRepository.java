package com.example.myproject.Repository;

import java.util.List;

import com.example.myproject.model.Employee;

public interface EmployeeRepository {
    Employee save(Employee employee);

    List<Employee> getEmployees();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}
