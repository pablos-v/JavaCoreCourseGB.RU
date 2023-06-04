package seminar3;

public abstract class Person implements Comparable<Person> {
    int rate;
    String name;
    int ID;

    public Person(int rate, String name, int ID) {
        this.rate = rate;
        this.name = name;
        this.ID = ID;
    }

    public abstract double salaryCounter();

    public int compareTo(Person o) {
        if (this.salaryCounter() > o.salaryCounter()){
            return 1;
        }
        if (this.salaryCounter() < o.salaryCounter()){
            return -1;
        }
        else return 0;
    }
}
