package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {


    @Before("aop.aspects.MyPointcuts.allPutMethods()")
    public void logger(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        if (methodSignature.getName().equals("putMag")) {
            System.out.println("methodSignature is " + methodSignature);
            System.out.println("MethodName is " + methodSignature.getName());
            System.out.println("methodSignature.getMethod() is " + methodSignature.getMethod());

            System.out.println("Logged");
            System.out.println("-----------------");
        } else {
            Object[] params = joinPoint.getArgs();
            for (Object param : params) {
                if (param instanceof Book) {
                    Book book = (Book) param;
                    System.out.println(book.getAuthor() + " " + book.getName() + " " + book.getYear());
                } else System.out.println(param.toString());
            }
        }
    }


}
