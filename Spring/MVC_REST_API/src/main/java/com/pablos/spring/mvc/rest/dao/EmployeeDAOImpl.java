package com.pablos.spring.mvc.rest.dao;

import com.pablos.spring.mvc.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // аннотация DAO
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired //мы уже описали этот БИН в классе MyConfig
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("from Employee"
                , Employee.class); // создаём запрос
        return query.getResultList(); // пуляеем запрос и сразу отдаём
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        return session.merge(employee); // записать в БД или перезаписать существующий
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee emp = session.get(Employee.class, id);
        return emp;
    }

    @Override
    public void delEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(employee);
    }
}
