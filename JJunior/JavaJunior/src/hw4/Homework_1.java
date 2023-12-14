package hw4;

import java.sql.*;

public class Homework_1 {

    /**
     * Задания необходимо выполнять на ЛЮБОЙ СУБД (postgres, mysql, sqllite, h2, ...)
     * <p>
     * 1. С помощью JDBC выполнить:
     * 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar, ...
     * 1.2 Добавить в таблицу 10 книг
     * 1.3 Сделать запрос select from book where author = 'какое-то имя' и прочитать его с помощью ResultSet
     */

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:database.db");

        prepareTables(connection);
        insertData(connection);
        executeSelect(connection, "Lukyanenko");

        connection.close();

    }

    private static void prepareTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("""
                    create table book (
                      id bigint,
                      name varchar(255),
                      author varchar(255)
                    )
                    """);
        }
    }

    private static void insertData(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("""
                    insert into book(id, name, author) 
                    values(1, 'Voina_i_mir', 'Tolstoy'),
                          (2, 'Investor', 'Buratino'),
                          (3, 'Chisla', 'Pelevin'),
                          (4, 'Spektr', 'Lukyanenko'),
                          (5, 'Neposeda', 'Lukyanenko'),
                          (6, 'Nedotyopa', 'Lukyanenko'),
                          (7, 'Porog', 'Lukyanenko'),
                          (8, 'Predel', 'Lukyanenko'),
                          (9, 'Pryzhok', 'Lukyanenko'),
                          (10, 'Zastava', 'Lukyanenko')""");
        }
    }

    private static void executeSelect(Connection connection, String author) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = String.format("SELECT id, name FROM book WHERE author = '%s'", author);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("id = " + id + ", name = " + name);
            }
        }
    }
}