package com.pablos.spring.boot.study.springboot_rest.dao;

import com.pablos.spring.boot.study.springboot_rest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // аннотация DAO
public class EmployeeDAOImpl implements EmployeeDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        // теперь сессии доставать не надо
        return entityManager.createQuery("from Employee").getResultList();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void delEmployee(Employee employee) {
        entityManager.remove(employee);
    }
}
