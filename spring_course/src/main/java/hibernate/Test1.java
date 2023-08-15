package hibernate;

import hibernate.entity.Admin;
import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Admin.class)// указать класс который будет связан с БД
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // создаём из фабрики сессию
            Employee first = new Employee("Pavel", "Kuzmin", "Home", 200_000);
            Admin admin = new Admin("Admin", "amin", "Home", 200_000);

            session.beginTransaction(); // начинаем транзакцию
//        session.save(first); // устарел - сохранить в БД (INSERT)
            session.persist(admin); // вместо save - сохранить в БД (INSERT)
            session.persist(first); // вместо save - сохранить в БД (INSERT)
            session.getTransaction().commit(); // коммит успешной операции (даже если SELECT), транзакция закрыта
        } finally {
            factory.close(); // если что, фабрика будет обязателльно закрыта
        }
    }
}
