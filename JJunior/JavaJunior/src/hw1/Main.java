package hw1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //* 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
        ArrayList<Integer> listOfRandomInts = Stream
                .generate(() -> ThreadLocalRandom.current().nextInt(1, 1_000_000))
                .limit(1000)
                .collect(Collectors.toCollection(ArrayList::new));

        // * 1.1 Найти максимальное
        System.out.println(listOfRandomInts.stream().max(Integer::max));

        // * 1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        System.out.println(listOfRandomInts.stream()
                .filter(it -> it > 500_000)
                .map(it -> it * 5 - 150)
                .reduce(Integer::sum));

        // * 1.3 Найти количество чисел, квадрат которых меньше, чем 100_000
        System.out.println(listOfRandomInts.stream()
                .filter(it -> Math.pow(it, 2) < 100_000)
                .count());

        // * 2.1 Создать список из 10-20 сотрудников
        List<Employee> listOfEmps = new ArrayList<>(10);
        listOfEmps.add(new Employee("Ivan", 22, 120_000, "IT"));
        listOfEmps.add(new Employee("Liam", 42, 110_000, "IT"));
        listOfEmps.add(new Employee("Mila", 32, 100_000, "IT"));
        listOfEmps.add(new Employee("Kolya", 20, 81_000, "HR"));
        listOfEmps.add(new Employee("Lida", 25, 90_000, "HR"));
        listOfEmps.add(new Employee("Roma", 27, 60_000, "SALES"));
        listOfEmps.add(new Employee("Stas", 34, 50_000, "SALES"));
        listOfEmps.add(new Employee("Lori", 31, 100_000, "SALES"));
        listOfEmps.add(new Employee("Egor", 44, 115_000, "MANAGEMENT"));
        listOfEmps.add(new Employee("Pavel", 40, 200_000, "MANAGEMENT"));

        // * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
        listOfEmps.stream().map(Employee::getDepartment).distinct().toList().forEach(System.out::println);

        // * 2.3 Всем сотрудникам, чья зарплата меньше 100_000, повысить зарплату на 20%
        listOfEmps.stream().filter(it -> it.getSalary() < 100_000).forEach(it -> it.setSalary(it.getSalary() * 1.2));

        // * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
//        Map<String, List<Employee>> map = listOfEmps.stream()
//                .collect(Collectors.toMap(Employee::getDepartment, it -> it));

        Map<String, List<Employee>> empByDept = listOfEmps.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        empByDept.entrySet().forEach(System.out::println);

        // * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела


    }


}
