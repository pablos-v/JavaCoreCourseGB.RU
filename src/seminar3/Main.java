package seminar3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // задания а) и б)
        Person[] employers = {
                new HourEmployee(500, "Ivan", 1),
                new FixPayEmployee(100_000, "Maria", 2),
                new HourEmployee(700, "Egor", 3),
                new FixPayEmployee(70_000, "Liza", 4)
        };
        for (Person p : employers) {
            System.out.println(p.salaryCounter());
        }

        System.out.println("--------------");

        // задание в)
        Arrays.sort(employers);

        // задание г)
        EmployersArray forIterable = new EmployersArray(employers);

        for (Person pers : forIterable) {
            System.out.println(pers.salaryCounter());
        }
    }
}
