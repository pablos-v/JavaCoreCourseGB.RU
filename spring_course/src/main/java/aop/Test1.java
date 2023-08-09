package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext spring = new AnnotationConfigApplicationContext(SpringConfig.class);

        Library lib = spring.getBean("library", Library.class);
        Book book = spring.getBean("book", Book.class);
//        lib.getBook();
        lib.putMag();
        lib.putBook("vasya", book);


        spring.close();
    }
}
