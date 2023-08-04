package spring_intro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
//        Pet dog = context.getBean("dog", Dog.class);
//        dog.voice();
        Person pers = context.getBean("personBean", Person.class);
        pers.callPet();

        context.close();
    }
}
