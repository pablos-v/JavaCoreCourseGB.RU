package org.pablos.spring.rest.client;

import org.pablos.spring.rest.client.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * это класс для соединения клиента с сервером!
 */
@Component
public class Communication {

    @Autowired // RestTemplate предоставляется СПРИНГом для совершения HTTP запросов
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/MVC_REST_API/api/employees";

    public List<Employee> getAllEmps() {
        // restTemplate.exchange отправляет реквест (адрес, тип запроса, БОДИ запроса, ParameterizedTypeReference)
        // ParameterizedTypeReference - вспомогательный тип для передачи параметризированного типа
        ResponseEntity<List<Employee>> response = restTemplate.exchange(URL,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
                });

        return response.getBody();
    }

    public Employee getEmp(int id) {
        return restTemplate.getForObject(URL + "/" + id, Employee.class);
    }

    public void saveEmp(Employee emp) {
        int id = emp.getId();
        if (id == 0) { //если нет такого, то POST и вернуть его строкой
            ResponseEntity<Employee> responseEntity =
                    restTemplate.postForEntity(URL, emp, Employee.class);
            System.out.println("NEW Employee added: \n" + responseEntity.getBody());
        } else { // если есть, то делаем PUT
            restTemplate.put(URL, emp);
            System.out.println("Employee with ID " + id + " was updated");
            System.out.println(getEmp(id));
        }
    }

    public void deleteEmp(int id) {
        restTemplate.delete(URL + "/" + id);
        System.err.println("Employee with ID " + id + " was deleted!");
    }

}
