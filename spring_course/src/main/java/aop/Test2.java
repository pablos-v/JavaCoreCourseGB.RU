package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        University university = context.getBean("university", University.class);

        System.out.println(university.getStudents());
        context.close();
    }

}
