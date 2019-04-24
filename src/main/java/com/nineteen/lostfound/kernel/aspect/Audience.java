package com.nineteen.lostfound.kernel.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

    @Pointcut("execution(* com.nineteen.lostfound.controller.AuthController.test(..))")
    public void performance(){}

    @Around("performance()")
    public void watchePerformance(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("start-----------------------");
            proceedingJoinPoint.proceed();
            System.out.println("end-------------------------");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("error-----------------------");
        }

    }


}
