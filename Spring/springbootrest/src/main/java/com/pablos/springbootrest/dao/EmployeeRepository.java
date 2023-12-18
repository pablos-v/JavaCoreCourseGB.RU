package com.pablos.springbootrest.dao;

import com.pablos.springbootrest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
