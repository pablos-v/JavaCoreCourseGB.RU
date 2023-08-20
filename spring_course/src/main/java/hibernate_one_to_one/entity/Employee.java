package hibernate_one_to_one.entity;

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
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private int salary;
    @OneToOne(cascade = CascadeType.ALL) // обозначается связь один-к-одному и
    // и каскадность - то есть операции будут выполняться каскадно не только на этой сущности, но и
    // и на связанных с ней тоже
    @JoinColumn(name = "details_id") // это FOREIGN KEY
    private Details employeeDetails; // поле с экземпляром класса, на который ведёт FOREIGN KEY

    public Employee() {
    }

    public Details getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(Details employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
