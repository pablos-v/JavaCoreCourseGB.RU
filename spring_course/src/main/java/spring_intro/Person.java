package spring_intro;

import org.springframework.beans.factory.annotation.Value;

//@Component("personBean")

public class Person {
//    @Autowired
//    @Qualifier("dogBean")
    public Pet pet;
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;
//@Autowired
    public Person(Pet pet) {
        System.out.println("Pers");
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void callPet() {
        System.out.println("- Hello, " + pet.getClass().getSimpleName().toUpperCase() + "!");
        pet.voice();
    }
}
