package hw3;

public class Main {
    public static void main(String[] args) {
        Pers pers = new Pers("Ivan", "Loginov", "codeWord!!!");

        String path = Homework.objectToFile(pers);

        System.out.println(Homework.FileToObject(path));
    }
}
