package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundTestingAspect {
    @Around("execution(* return*(..))")
    public Object aroundTestAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundTestAdvice before");

        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        }

        System.out.println("aroundTestAdvice after");
        return targetMethodResult;
    }
}
