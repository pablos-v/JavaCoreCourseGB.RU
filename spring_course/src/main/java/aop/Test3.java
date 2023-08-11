package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(" Main starts ");

//        long begin = System.currentTimeMillis();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        long end = System.currentTimeMillis();
//        System.out.println("AnnotationConfigApplicationContext constructing time: " + (end-begin) + " ms");

        Library library = context.getBean("library", Library.class);
        String bookName = library.returnBook();
        System.out.println("Returned book " + bookName);

        context.close();

        System.out.println(" Main ends ");
    }

}
