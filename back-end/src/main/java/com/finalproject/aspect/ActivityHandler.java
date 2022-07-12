package com.finalproject.aspect;

import com.finalproject.models.ActivityLog;
import com.finalproject.repository.ActivityLogRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Aspect
@Component
public class ActivityHandler {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ActivityLogRepo activityLogRepo;

    @Pointcut("within(com.finalproject.controllers..*)")
    public void logAnyFunction() {}

    @Around("logAnyFunction()")
    public Object writeLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("Class Name: "
                + proceedingJoinPoint.getSignature().getDeclaringTypeName() +". Method Name: "
                + proceedingJoinPoint.getSignature().getName()+ ". Time taken for Execution is : " + (endTime-startTime) + "ms");
        ActivityLog activityLog = new ActivityLog(new Date(), proceedingJoinPoint.getSignature().getName(), endTime-startTime);
        activityLogRepo.save(activityLog);
        return object;
    }
}
