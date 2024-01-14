package hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    private Employee emp;

    @BeforeEach
    void setUp() {
        emp = new Employee("Ivan", 22, 120_000, "IT");
    }

    @Test
    void setAge() {
        emp.setAge(45);
        assertEquals(45, emp.getAge());
        assertNotEquals(22, emp.getAge());
    }

    @Test
    void setSalary() {
    }

    @Test
    void setDepartment() {
    }

    @Test
    void getName() {
    }

    @Test
    void getAge() {
    }

    @Test
    void getSalary() {
    }

    @Test
    void getDepartment() {
    }
}