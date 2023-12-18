package com.pablos.springbootdao.restapi.dao;


import com.pablos.springbootdao.restapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByName(String name);
    List<Employee> findAllByNameOrSalary(String name, Integer salary);

}
