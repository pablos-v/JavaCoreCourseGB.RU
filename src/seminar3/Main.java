package seminar3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 1. Построить три класса (базовый и 2 потомка), описывающих некоторых работников с почасовой оплатой (один из потомков)
 * и фиксированной оплатой (второй потомок).
 * а) Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
 * Для «повременщиков» формула для расчета такова: «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка»,
 * для работников с фиксированной оплатой «среднемесячная заработная плата = фиксированная месячная оплата».
 * б) Создать на базе абстрактного класса массив сотрудников и заполнить его.
 * в) ** Реализовать интерфейсы для возможности сортировки массива (обратите ваше внимание на интерфейсы Comparator, Comparable)
 * г) ** Создать класс, содержащий массив сотрудников, и реализовать возможность вывода данных с использованием foreach.
 */
public class Main {
    public static void main(String[] args) {
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

        EmployersArray forIterable = new EmployersArray(employers);
        while (forIterable.hasNext()) {
            System.out.println(forIterable.next().salaryCounter());
        }

        System.out.println("--------------");

//        for (Person per: forIterable){
//            System.out.println(per.salaryCounter());
//        }
    }
}
