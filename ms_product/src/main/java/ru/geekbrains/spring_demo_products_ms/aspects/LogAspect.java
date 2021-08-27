package ru.geekbrains.spring_demo_products_ms.aspects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAspect {
    @Pointcut("execution(public * ru.geekbrains.spring_demo_products_ms.controllers..*.*(..))")
    private void controllersPointcut(){}

    @Before("controllersPointcut()")
    public void logBefore(JoinPoint point) {
        log.info("Before request processing");
        try {
            ObjectMapper mapper = new ObjectMapper();
            String logStr = String.format("Request params of %s: %s%n", point.getSignature().toShortString(), mapper.writeValueAsString(point.getArgs()));
            log.info(logStr);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }

    }
}
