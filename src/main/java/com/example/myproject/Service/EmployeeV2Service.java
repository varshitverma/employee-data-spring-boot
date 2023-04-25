package com.example.myproject.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myproject.Repository.EmployeeJpaRepository;
import com.example.myproject.Repository.EmployeeRepository;
import com.example.myproject.entity.EmployeeEntity;
import com.example.myproject.model.Employee;

@Service
public class EmployeeV2Service implements EmployeeRepository {


    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Override
    public Employee save(Employee employee) {

        if (employee.getEmployeeId() == null ||
            employee.getEmailId().isEmpty()) {

            employee.setEmployeeId(UUID.randomUUID().toString());
            
        }

        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, entity);
        employeeJpaRepository.save(entity);

        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeJpaRepository.findAll();
        List<Employee> employeeList = 
                        employeeEntityList.stream()
                        .map(employeeEntity -> {
                            Employee employee = new Employee();
                            BeanUtils.copyProperties(employeeEntity, employee);
                            return employee;
                        })
                        .collect(Collectors.toList());

        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeEntity employeeEntity = employeeJpaRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeJpaRepository.deleteById(id);
        return "Employee Deleted with the Id :" + id;
    }

    
}
