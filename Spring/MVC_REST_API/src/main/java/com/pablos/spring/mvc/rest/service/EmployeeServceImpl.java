package com.pablos.spring.mvc.rest.service;

import com.pablos.spring.mvc.rest.dao.EmployeeDAO;
import com.pablos.spring.mvc.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //аннотация сервиса
public class EmployeeServceImpl implements EmployeeService {
    @Autowired //подтягиваем бин ДАО через интерфейс
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional //в ДАО уже не нужно указывать автотранзактность, она стала на уровень выше, здесь
    public List<Employee> getAllEmployees() {
        // тут логика какой ДАО выбрать
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void delEmployee(Employee employee) {
        employeeDAO.delEmployee(employee);
    }
}
