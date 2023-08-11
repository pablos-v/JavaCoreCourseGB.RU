package aop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UniversityLoggingAspect {

//    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exc")
//    public void afterThrowingExceptionGetStudentsLoggingAdvice(Throwable exc) {
//        System.err.println("Log mistake!!! " + exc);
//    }
    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("Log before");
    }
    @After("execution(* getStudents())")
    public void afterGetStudentsLogAdvice(){
        System.out.println("Log AFTER FINALLY");
    }

//    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
//    public void afterGetStudentsLoggingAdvice(List<Student> students) {
//        students.remove(1);
//        System.out.println("Log After R");
//    }

}
