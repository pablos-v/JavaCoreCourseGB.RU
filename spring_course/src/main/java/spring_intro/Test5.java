package spring_intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test5 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person pers = context.getBean("personBean", Person.class);
        pers.callPet();


        context.close();
    }
}
