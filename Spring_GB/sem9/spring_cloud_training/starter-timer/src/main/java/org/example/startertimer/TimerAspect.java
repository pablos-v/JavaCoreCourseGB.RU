package org.example.startertimer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
@RequiredArgsConstructor
public class TimerAspect {



    @Pointcut("@annotation(Timer)")
    public void hasTimerAnnotation() {
    }

    @Around("hasTimerAnnotation()")
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
