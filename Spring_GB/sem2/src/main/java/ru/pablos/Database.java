package ru.pablos;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Data
@Repository
public class Database {
    public List<Student> ls;

    public Database() {
        this.ls = new ArrayList<>();

        ls.add(new Student("Ivan", "Staraya"));
        ls.add(new Student("Lola", "Novaya"));
        ls.add(new Student("Kolya", "Novaya"));
        ls.add(new Student("Sasha", "Staraya"));
        ls.add(new Student("Liza", "Staraya"));
        ls.add(new Student("Agata", "Novaya"));
        ls.add(new Student("Sveta", "Staraya"));
    }
}
