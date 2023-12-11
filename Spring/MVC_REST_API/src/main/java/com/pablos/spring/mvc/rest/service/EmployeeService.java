package com.pablos.spring.mvc.rest.service;

import com.pablos.spring.mvc.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);

    Employee getEmployee(int id);
    void delEmployee(Employee employee);
}
