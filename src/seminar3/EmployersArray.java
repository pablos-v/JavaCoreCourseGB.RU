package seminar3;

import java.util.Iterator;
import java.util.function.Consumer;

public class EmployersArray implements Iterable<Person> {
    Person[] allPersons;

    public EmployersArray(Person[] allPersons) {
        this.allPersons = allPersons;
    }

    @Override
    public Iterator<Person> iterator() {
        return new EmployersArrayIterator();
    }

    @Override
    public void forEach(Consumer<? super Person> action) {
        Iterable.super.forEach(action);
    }

    public class EmployersArrayIterator implements Iterator<Person> {

        int index;

        public EmployersArrayIterator() {
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
}

