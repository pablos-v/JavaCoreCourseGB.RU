package com.pablos.springbootdao.restapi.controller;

import com.pablos.springbootdao.restapi.entity.Employee;
import com.pablos.springbootdao.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // не просто контроллер, а именно РЕСТ
@RequestMapping("/api") // это будет корень для всех маппингов этого контроллера
public class MyRESTController {
    @Autowired // сервис стоит между DAO и фронтКонтроллером, для гибкости
    private EmployeeService employeeService;

    @GetMapping(value = {"/employees", "/employees/"}) // мултимэппинг
    public List<Employee> showAllEmps() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = {"/employees/nameorsal/{name}&{sal}"})
    public List<Employee> getAllByNameOrSal(@PathVariable("name") String name, @PathVariable("sal") Integer sal) {
        return employeeService.getAllByNameOrSalary(name, sal);
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmpsByName(@PathVariable("name") String name) {
        return employeeService.findAllByName(name);
    }

    @GetMapping("/employees/{i}") //Аннотация @PathVariable используется для
    //    получения значения переменной из адреса запроса
    public Employee showOneEmp(@PathVariable("i") int id) {
        Employee emp = employeeService.getEmployee(id);
        return emp;
    }

    @PostMapping(value = {"/employees", "/employees/"}) // @RequestBody связывает тело HTTP POST-запроса с параметром
    public Employee postEmployee(@RequestBody Employee emp) {
        return employeeService.saveEmployee(emp);
    }

    @PutMapping(value = {"/employees", "/employees/"})
    public Employee putEmployee(@RequestBody Employee emp) {
        return employeeService.saveEmployee(emp);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.delEmployee(employeeService.getEmployee(id));
        return "Deleted Employee with ID = " + id;
    }
}
