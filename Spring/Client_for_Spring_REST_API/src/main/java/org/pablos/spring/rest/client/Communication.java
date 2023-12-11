package org.pablos.spring.rest.client;

import org.pablos.spring.rest.client.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * это класс для соединения клиента с сервером
 */
@Component
public class Communication {

    @Autowired // RestTemplate предоставляется СПРИНГом для совершения HTTP запросов
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/MVC_REST_API/api/employees";

    public List<Employee> showAllEmps() {

        return null;
    }

    public Employee getEmp(int id) {

        return null;
    }

    public void saveEmp(Employee emp) {

    }

    public void deleteEmp(int id) {

    }

}
