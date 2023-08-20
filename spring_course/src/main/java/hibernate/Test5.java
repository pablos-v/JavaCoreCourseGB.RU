package hibernate;

import hibernate.entity.Admin;
import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Admin.class)// указать класс который будет связан с БД
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // создаём из фабрики сессию
            session.beginTransaction(); // начинаем транзакцию
//            Employee ee = new Employee("QQQ", "ww", "123", 456);
//session.persist(ee);
            session.createMutationQuery("DELETE Employee WHERE name = 'Admin'").executeUpdate();

            session.getTransaction().commit(); // транзакция закрыта
        } finally {
            factory.close(); // фабрика будет обязательно закрыта
        }

    }
}
