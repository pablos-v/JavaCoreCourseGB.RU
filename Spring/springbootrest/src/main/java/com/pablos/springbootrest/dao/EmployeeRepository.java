package com.pablos.springbootrest.dao;

import com.pablos.springbootrest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @RestResource(path = "names", rel = "names")
    List<Employee> findAllByNameOrSalary(@Param("name") String name, @Param("salary") Integer salary);
}
