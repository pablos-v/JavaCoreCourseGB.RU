package hibernate_one_to_many_one.entity;

import jakarta.persistence.*;

@Entity // этот класс связан с БД
@Table(name = "employees") // с какой таблицей БД он связан
public class Employee {
    @Column(name = "id") // к какому столбцу таблицы относится это поле
    @Id // это PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "salary")
    private int salary;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}) // обозначается связь много-к-одному и
    // и каскадность - то есть операции будут выполняться каскадно не только на этой сущности, но и
    // и на связанных с ней тоже
    @JoinColumn(name = "department_id") // это FOREIGN KEY
    private Department department; // поле с экземпляром класса, на который ведёт FOREIGN KEY

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {
    }

    public Employee(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


}
