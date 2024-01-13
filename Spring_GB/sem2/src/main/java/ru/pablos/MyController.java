package ru.pablos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private Database db;

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return db.getLs().get(id);
    }

    @GetMapping("/students/")
    public List<Student> getAllStudents() {
        return db.getLs();
    }

    @GetMapping("/student/search") // /student/search?name='studentName'
    public List<Student> getAllBySubstring(@RequestParam String name) {
        return db.getLs().stream().filter((it) -> it.getName().contains(name)).toList();
    }

    @GetMapping("/group/{groupName}")
    public List<Student> getAllByGroup(@PathVariable String groupName) {
        return db.getLs().stream().filter((it) -> it.getGroupName().equals(groupName)).toList();
    }

    @PostMapping("/student")
    public void addNewStudent(@RequestBody Student student) {
        db.getLs().add(student);
    }

    @DeleteMapping("/student/{id}")
    public Student deleteById(@PathVariable int id) {
        return db.getLs().remove(id);
    }

}
