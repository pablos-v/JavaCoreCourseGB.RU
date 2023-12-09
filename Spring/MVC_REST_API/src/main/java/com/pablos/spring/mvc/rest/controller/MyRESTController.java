package com.pablos.spring.mvc.rest.controller;

import com.pablos.spring.mvc.rest.entity.Employee;
import com.pablos.spring.mvc.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmps() {
        return employeeService.getAllEmployees();
    }

//    @GetMapping("/employees")
//    public Employee showOneEmp(@RequestParam("empId") int id) {
//        return employeeService.getEmployee(id);
//    }
}
