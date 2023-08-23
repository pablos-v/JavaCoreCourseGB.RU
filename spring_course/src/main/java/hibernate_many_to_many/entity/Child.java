package hibernate_many_to_many.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "children")
public class Child {
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "age")
    private int age;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(
            name = "child_section" // это имя JoinTable в БД
            , joinColumns = @JoinColumn(name = "child_id") // FOREIGN KEY в табл child_section, ведущий на наш класс (source)
            , inverseJoinColumns = @JoinColumn(name = "section_id") // FOREIGN KEY в табл child_section, ведущий на второй класс (target)
    )
    List<Section> sections;

    public void addSectionToChild(Section section){
        if (sections == null) sections = new ArrayList<>();
        sections.add(section);
    }

    public Child(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public Child() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSections() {
        return sections;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
