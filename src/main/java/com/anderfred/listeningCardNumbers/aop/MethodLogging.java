package com.anderfred.listeningCardNumbers.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MethodLogging {
    private final Log log = LogFactory.getLog(this.getClass());

    @Around("@annotation(com.anderfred.listeningCardNumbers.aop.LogAOP)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object o = joinPoint.proceed();
        log.info(joinPoint.toString() + " args: " + Arrays.toString(joinPoint.getArgs()));
        log.info("after exec return values:" + o);
        return o;
    }
}