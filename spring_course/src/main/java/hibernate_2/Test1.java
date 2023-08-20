package hibernate_2;

import hibernate_2.entity.Details;
import hibernate_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class) // указать класс который будет связан с БД
                .addAnnotatedClass(Details.class) // указать класс который будет связан с БД
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) { // создаём из фабрики сессию

            session.beginTransaction(); // начинаем транзакцию

            Employee first = new Employee("Pavel", "Kuzmin", "Home", 200_000);
            Details empDets = new Details("Baires", "113554681", "855@mail.ru");
            first.setEmployeeDetails(empDets); // привязать объект на который ведёт FOREIGN KEY

            session.persist(first); // сохранить в БД достаточно основной объект, второй создастся и запишется в таблицу сам, т.к. указан cascade = CascadeType.ALL

            session.getTransaction().commit(); // коммит успешной операции (даже если SELECT), транзакция закрыта
        }
    }
}
