package hw3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * тренируюсь сериализовать
 */

public class Pers implements Serializable {
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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Pers pers = new Pers("Ivan", "Loginov", "codeWord!!!");

        Files.deleteIfExists(Path.of("hw3_Externals.out"));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("hw3_Externals.out"))) {
            out.writeObject(pers);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("hw3_Externals.out"))) {
            pers = (Pers) in.readObject();
        }

        System.out.println(pers);
    }
}
