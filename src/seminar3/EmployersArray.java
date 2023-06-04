package seminar3;

import java.util.Iterator;
import java.util.function.Consumer;

public class EmployersArray implements Iterator<Person> {
    int index;
    Person[] allPersons;

    public EmployersArray(Person[] allPersons) {
        this.allPersons = allPersons;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < allPersons.length;
    }

    @Override
    public Person next() {
        return allPersons[index++];
    }
}

