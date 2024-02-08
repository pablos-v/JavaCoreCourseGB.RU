package ru.gb.springdemo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeLoggingAspect {

    @Pointcut("within(ru.gb.springdemo.view_controllers.*)")
    public void everyBeanInPackage() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void methodsAnnotatedWith() {
    }

    @Pointcut("execution(* ru.gb.springdemo.view_controllers.*.viewAll*(..))")
    public void everyViewAllMethodInPackage() {
    }

    @Around("everyBeanInPackage()")
    public Object timeLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            log.info("exception = [{}, {}]", e.getClass(), e.getMessage());
            throw e;
        }

        long result = System.currentTimeMillis() - start;
        String className = String.valueOf(proceedingJoinPoint.getTarget().getClass());
        String methodName = String.valueOf(proceedingJoinPoint.getSignature().getName());
        log.info("total working time of method {} in class {} is {} millis", methodName, className, result);

        return proceed;
    }

}
