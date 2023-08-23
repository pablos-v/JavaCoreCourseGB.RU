package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

//            Section section1 = new Section("footbal");
//            Section section2 = new Section("swimming");
//            Section section3 = new Section("flying");
//
//            Child child1 = new Child("Vasyan", 10);
//            Child child2 = new Child("EE", 10);
//            Child child3 = new Child("Viccy", 5);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            section2.addChildToSection(child2);
//            child1.addSectionToChild(section3);

            session.beginTransaction();

            Child vasyan = session.get(Child.class, 6);
            Section sec = session.get(Section.class, 6);
            vasyan.addSectionToChild(sec);
            System.out.println(vasyan.getSections());

            session.getTransaction().commit();
        }


    }
}
