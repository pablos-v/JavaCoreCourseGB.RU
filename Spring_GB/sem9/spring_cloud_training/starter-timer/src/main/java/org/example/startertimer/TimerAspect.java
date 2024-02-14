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

    private final TimerProps properties;

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
            doLog("exception = [{}, {}]", e.getClass(), e.getMessage());
            throw e;
        }

        long result = System.currentTimeMillis() - start;
        String timeCountingValue = "millis";
        String className = String.valueOf(proceedingJoinPoint.getTarget().getClass());
        String methodName = String.valueOf(proceedingJoinPoint.getSignature().getName());
        if (properties.getTimeCounting().equals(TimeCounting.SECONDS)) {
            result = result / 1000;
            timeCountingValue = "seconds";
        }
        doLog("total working time of method {} in class {} is {} {}", methodName
                , className, result, timeCountingValue);

        return proceed;
    }

    private void doLog(String text, Object... params) {
        log.atLevel(properties.getLogLevel()).log(text, params);
    }
}
