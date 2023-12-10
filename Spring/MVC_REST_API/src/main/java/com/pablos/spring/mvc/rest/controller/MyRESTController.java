package com.pablos.spring.mvc.rest.controller;

import com.pablos.spring.mvc.rest.entity.Employee;
import com.pablos.spring.mvc.rest.exception_handling.EmplIncorrectData;
import com.pablos.spring.mvc.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/employees/{i}") //Аннотация @PathVariable используется для
    //    получения значения переменной из адреса запроса
    public Employee showOneEmp(@PathVariable("i") int id) throws NoSuchFieldException {
        Employee emp = employeeService.getEmployee(id);
        if (emp == null) {
            // если ID будет int, но такого объекта не будет в БД, то отдаёт null,
            // а нам лучше увидеть сообщение
            throw new NoSuchFieldException("No such Employee for ID = " + id);
        }
        return emp;
    }


//    @PostMapping("/employees")
//    public void postEmployee(Employee emp){
//        employeeService.saveEmployee(emp);
//    }
//
//    @PutMapping("/employees")
//    public void putEmployee(Employee emp){
//        employeeService.saveEmployee(emp);
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public void deleteEmployee(@PathVariable int id){
//        employeeService.delEmployee(employeeService.getEmployee(id));
//    }
}
