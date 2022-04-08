package edu.miu.waa.lab1.aspect;

import edu.miu.waa.lab1.model.Logger;
import edu.miu.waa.lab1.repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

import static java.time.LocalTime.MIN;


@Aspect
@Component
public class LoggerAspect {

    @Autowired
    LoggerRepo loggerRepo;

    Logger logger;

    @Pointcut("@annotation(edu.miu.waa.lab1.aspect.annotations.ExecutionTime)")
    public void annotationPointcut() {
    }

    @Around("annotationPointcut()")
    public void logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long count = 1;
        long startTime = System.currentTimeMillis();
//LocalTime.now();
        proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();
                //LocalTime.now();


         logger = new Logger(logger.getTransactionId() + count, LocalDate.now(), endTime - startTime, "fake user", proceedingJoinPoint.getSignature().getName());
        loggerRepo.save(logger);

    }


    @Pointcut("execution(* edu.miu.waa.lab1.controller.UserController.*(..))")
    public void logMe() {

    }

    @Before("logMe()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before" + joinPoint.getSignature().getName());
    }

    @After("logMe()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After" + joinPoint.getSignature().getName());
    }

}
