package seminar3;

import java.util.Iterator;

public abstract class Person {
    int rate;
    String name;
    int ID;

    public Person(int rate, String name, int ID) {
        this.rate = rate;
        this.name = name;
        this.ID = ID;
    }

    public abstract double salaryCounter();

}
