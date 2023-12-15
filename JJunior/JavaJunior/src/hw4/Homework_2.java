package hw4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * * <p>
 * * 2. С помощью JPA(Hibernate) выполнить:
 * * 2.1 Описать сущность Book из пункта 1.1
 * * 2.2 Создать Session и сохранить в таблицу 10 книг
 * * 2.3 Выгрузить список книг какого-то автора
 * * <p>
 * * 3.* Создать сущность Автор (id biging, name varchar), и в сущности Book сделать поле типа Author (OneToOne)
 * * 3.1 * Выгрузить Список книг и убедиться, что поле author заполнено
 * * 3.2 ** В классе Author создать поле List<Book>, которое описывает список всех книг этого автора. (OneToMany)
 */
public class Homework_2 {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = new Configuration()
                .configure("hw4/hibernate.cfg.xml").buildSessionFactory();

        putBooksInDB(sessionFactory);
        getBooksFromDB(sessionFactory, "Lukyanenko");

        sessionFactory.close();
    }
    private static void putBooksInDB(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(new Book(1, "Voina_i_mir", "Tolstoy"));
            session.persist(new Book(2, "Investor", "Buratino"));
            session.persist(new Book(3, "Chisla", "Pelevin"));
            session.persist(new Book(4, "Spektr", "Lukyanenko"));
            session.persist(new Book(5, "Neposeda", "Lukyanenko"));
            session.persist(new Book(6, "Nedotyopa", "Lukyanenko"));
            session.persist(new Book(7, "Porog", "Lukyanenko"));
            session.persist(new Book(8, "Predel", "Lukyanenko"));
            session.persist(new Book(9, "Pryzhok", "Lukyanenko"));
            session.persist(new Book(10, "Zastava", "Lukyanenko"));

            session.getTransaction().commit();
        }
    }

    private static void getBooksFromDB(SessionFactory sessionFactory, String author) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            String query = String.format("SELECT b FROM Book b WHERE author = '%s'", author);
            List<Book> books = session.createQuery(query, Book.class)
                    .getResultList();

            System.out.println(books);

            session.getTransaction().commit();
        }
    }


}
