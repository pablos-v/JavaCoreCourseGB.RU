package hibernate;

import hibernate.entity.Admin;
import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Admin.class)// указать класс который будет связан с БД
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // создаём из фабрики сессию

            session.beginTransaction(); // начинаем транзакцию

            session.createMutationQuery("UPDATE Employee set salary = 1000 WHERE department = 'Home'").executeUpdate();

            session.getTransaction().commit(); // коммит успешной операции (даже если SELECT), транзакция закрыта
        } finally {
            factory.close(); // если что, фабрика будет обязателльно закрыта
        }

    }
}
