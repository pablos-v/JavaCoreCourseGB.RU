package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class) // указать класс который будет связан с БД
                .addAnnotatedClass(Department.class) // указать класс который будет связан с БД
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) { // создаём из фабрики сессию

            session.beginTransaction(); // начинаем транзакцию

            Employee first = new Employee("Pavel", "Kuzmin", 200_000);
            Department dep = session.get(Department.class,1);

            dep.addEmpToDepart(first);

            session.persist(dep);

            session.getTransaction().commit(); // коммит успешной операции (даже если SELECT), транзакция закрыта
        }
    }
}
