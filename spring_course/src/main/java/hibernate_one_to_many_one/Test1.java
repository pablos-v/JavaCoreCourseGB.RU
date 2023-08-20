package hibernate_one_to_many_one;

import hibernate_one_to_many_one.entity.Department;
import hibernate_one_to_many_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class) // указать класс который будет связан с БД
                .addAnnotatedClass(Department.class) // указать класс который будет связан с БД
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) { // создаём из фабрики сессию

            session.beginTransaction(); // начинаем транзакцию

            Department first = session.get(Department.class, 2);
            session.remove(first);

            session.getTransaction().commit(); // коммит успешной операции (даже если SELECT), транзакция закрыта
        }
    }
}
