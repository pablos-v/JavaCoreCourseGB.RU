package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* get*(..))")
    private void pc(){}

    @Before("pc()")
    public void beforeGetBookAdvice() {
        System.out.println("LOGGER LUNCHED!");
    }
}
