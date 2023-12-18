package com.pablos.spring.boot.study.springboot_rest.dao;

import com.pablos.spring.boot.study.springboot_rest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // аннотация DAO
public class EmployeeDAOImpl implements EmployeeDAO {
    @PersistenceContext
    private EntityManager entityManager;

        @Override
    public List<Employee> getAllEmployees() {
            // теперь сессии доставать надо так
        Session session = entityManager.unwrap(Session.class);
            // правда мы всё ещё используем гибернейтовский класс Session...

        Query<Employee> query = session.createQuery("from Employee"
                , Employee.class); // создаём запрос
        return query.getResultList(); // пуляеем запрос и сразу отдаём
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        return session.merge(employee); // записать в БД или перезаписать существующий
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee emp = session.get(Employee.class, id);
        return emp;
    }

    @Override
    public void delEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(employee);
    }
}
