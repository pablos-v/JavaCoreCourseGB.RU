package com.pablos.spring.mvc.rest.dao;

import com.pablos.spring.mvc.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void delEmployee(Employee employee);
}
