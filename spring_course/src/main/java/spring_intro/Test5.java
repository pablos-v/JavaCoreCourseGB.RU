package spring_intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test5 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person pers = context.getBean("personBean", Person.class);
        Person pers1 = context.getBean("personBean", Person.class);
        System.out.println(pers1==pers);
        System.out.println(pers1.pet == pers.pet);
        pers.callPet();


        context.close();

    }
}
