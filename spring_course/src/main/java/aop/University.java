package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class University {
    private final List<Student> students= new ArrayList<>();

    public University() {
        addStudents();
    }

    private void addStudents(){
        Student st1 = new Student("Pavwl", 12, 3.2);
        Student st2 = new Student("Nick", 10, 4.2);
        Student st3 = new Student("Olga", 1, 5.0);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents() {
        System.out.println(students);
        return students;
    }
}
