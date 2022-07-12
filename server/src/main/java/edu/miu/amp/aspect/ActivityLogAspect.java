package edu.miu.amp.aspect;

import edu.miu.amp.domain.ActivityLog;
import edu.miu.amp.helper.UserPrincipal;
import edu.miu.amp.repository.ActivityLogRepo;
import edu.miu.amp.repository.UserRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class ActivityLogAspect {


    @Autowired
    private ActivityLogRepo activityLogRepo;

    @Autowired
    private UserRepo userRepo;

    //    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
//            " || within(@org.springframework.stereotype.Service *)" +
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {

    }

    @AfterThrowing(pointcut = "springBeanPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {

        var errorLog = new ActivityLog();
        errorLog.setCreatedAt(new Date());

        errorLog.setMessage(String.format("Exception in %s.%s()", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName()));
        activityLogRepo.save(errorLog);

    }


    @Around("springBeanPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        var enterLog = new ActivityLog();
        enterLog.setCreatedAt(new Date());

        enterLog.setMessage(String.format("Enter: %s.%s() with argument[s] = %s", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
        activityLogRepo.save(enterLog);

        try {
            Object result = joinPoint.proceed();

            var exitLog = new ActivityLog();
            exitLog.setCreatedAt(new Date());

            exitLog.setMessage(String.format("Exit: %s.%s() with result = %s", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), result != null ? result.toString() : ""));
            activityLogRepo.save(exitLog);

            return result;
        } catch (IllegalArgumentException e) {

            var errorLog = new ActivityLog();
            errorLog.setCreatedAt(new Date());

            errorLog.setMessage(String.format("Illegal argument: %s in $s.%s()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName()));
            activityLogRepo.save(errorLog);

            throw e;
        }
    }
}