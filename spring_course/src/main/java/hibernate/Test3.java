package hibernate;

import hibernate.entity.Admin;
import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Admin.class)// указать класс который будет связан с БД
                .buildSessionFactory();

        Employee pablos;
        try {
            Session session = factory.getCurrentSession(); // создаём из фабрики сессию

            session.beginTransaction(); // начинаем транзакцию

            List<Employee> ls = session.createSelectionQuery("FROM Employee " + "WHERE name = 'Pavel' AND salary > 100", Employee.class).getResultList();
            for (Employee e : ls) System.out.println(e);

            session.getTransaction().commit(); // коммит успешной операции (даже если SELECT), транзакция закрыта
        } finally {
            factory.close(); // если что, фабрика будет обязателльно закрыта
        }
    }
}
