package hibernate_many_to_many.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(
            name = "child_section" // это имя JoinTable в БД
            , joinColumns = @JoinColumn(name = "section_id") // FOREIGN KEY в табл child_section, ведущий на наш класс
            , inverseJoinColumns = @JoinColumn(name = "child_id") // FOREIGN KEY в табл child_section, ведущий на второй класс
    )
    List<Child> children;


    public void addChildToSection(Child child) {
        if (children == null) children = new ArrayList<>();
        children.add(child);
    }

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                '}';
    }
}
