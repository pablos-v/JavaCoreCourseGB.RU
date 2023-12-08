package hw3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * тренируюсь сериализовать
 */

public class Pers implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private transient String password;

    public Pers(String name, String surname, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Pers{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
