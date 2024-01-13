package ru.pablos;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Student {

    private static int idCounter = 0;
    private String name;
    private int id;
    private String groupName;

    public Student(String name, String groupName){
        this.groupName = groupName;
        this.name = name;
        this.id = idCounter++;
    }

    public Student() {
    }
}
