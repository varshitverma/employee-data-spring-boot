package com.example.myproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myproject.entity.EmployeeEntity;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, String> {
    
}
