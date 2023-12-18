package com.pablos.springbootdao.restapi.service;

import com.pablos.springbootdao.restapi.dao.EmployeeRepository;
import com.pablos.springbootdao.restapi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service //аннотация сервиса
public class EmployeeServceImpl implements EmployeeService {
    @Autowired //подтягиваем бин ДАО
    private EmployeeRepository employeeRepository;

    @Override
    // @Transactional уже не нужно указывать автотранзактность, она идёт по умолчанию
    public List<Employee> getAllEmployees() {
        // тут логика какой ДАО выбрать
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllByName(String name) {
        return employeeRepository.findAllByName(name);
    }

    @Override
    public List<Employee> getAllByNameOrSalary(String name, Integer salary) {
        return employeeRepository.findAllByNameOrSalary(name, salary);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else throw new RuntimeException("No such Employee!");
    }

    @Override
    public void delEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }
}
