package hibernate_one_to_one;

import hibernate_one_to_one.entity.Details;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class) // указать класс который будет связан с БД
                .addAnnotatedClass(Details.class) // указать класс который будет связан с БД
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) { // создаём из фабрики сессию

            session.beginTransaction(); // начинаем транзакцию

            Employee employee = session.get(Employee.class,3);

            System.out.println(employee);

            session.getTransaction().commit(); // коммит успешной операции
        }
    }
}
