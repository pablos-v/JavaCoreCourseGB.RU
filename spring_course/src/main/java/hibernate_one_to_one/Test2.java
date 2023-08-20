package hibernate_one_to_one;

import hibernate_one_to_one.entity.Details;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class) // указать класс который будет связан с БД
                .addAnnotatedClass(Details.class) // указать класс который будет связан с БД
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) { // создаём из фабрики сессию

            session.beginTransaction(); // начинаем транзакцию

            Employee employee = new Employee("Nona", "Fala", "IT", 300_000);
            Details empDets = new Details("Cordoba", "113554231", "x855@gmail.com");
            employee.setEmployeeDetails(empDets); // привязать объект на который ведёт FOREIGN KEY
            empDets.setEmp(employee); // для двусторонней связи объектов и таблиц

            session.persist(empDets); // сохранить в БД любой объект, второй создастся и запишется в таблицу сам,
            // т.к. указан cascade = CascadeType.ALL и двусвязное отношение

            session.getTransaction().commit(); // коммит успешной операции
        }
    }
}
