package com.pablos.springbootdao.restapi.service;



import com.pablos.springbootdao.restapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    List<Employee> findAllByName(String name);
    List<Employee> getAllByNameOrSalary(String name, Integer salary);
    Employee saveEmployee(Employee employee);

    Employee getEmployee(int id);
    void delEmployee(Employee employee);


}
