package hw3;

import java.io.*;
import java.util.UUID;

public class Homework {

    /**
     * Написать класс с двумя методами:
     * 1. принимает объекты, имплементирующие интерфейс serializable, и сохраняющие их в файл.
     * Название файл - class.getName() + "_" + UUID.randomUUID().toString()
     * 2. принимает строку вида class.getName() + "_" + UUID.randomUUID().toString() и загружает объект из файла и удаляет этот файл.
     * <p>
     * Что делать в ситуациях, когда файла нет или в нем лежит некорректные данные - подумать самостоятельно.
     */

    public static String objectToFile(Serializable obj){
        String path = obj.getClass().getName() + "_" + UUID.randomUUID();

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

    public static Object FileToObject(String path) {
        Object object = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            object = in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Huston, we have a problem! It`s " + e);
        }
        return object;
    }
}