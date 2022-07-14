package com.cs545waa.waaJune2022finalProject.aspect;
        import org.aspectj.lang.ProceedingJoinPoint;
        import org.aspectj.lang.annotation.Around;
        import org.aspectj.lang.annotation.Aspect;
        import org.aspectj.lang.annotation.Pointcut;
        import org.springframework.stereotype.Component;
        import org.aspectj.lang.ProceedingJoinPoint;
        import org.aspectj.lang.annotation.Around;
        import org.aspectj.lang.annotation.Aspect;
        import org.aspectj.lang.annotation.Pointcut;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.stereotype.Component;

        import com.fasterxml.jackson.databind.ObjectMapper;
        import javax.servlet.http.HttpServletRequest;
        import java.time.LocalDate;
@Aspect
@Component
public class LoggingAspect{

    Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut(value="execution(* com.cs545waa.waaJune2022finalProject.*.*.*(..)))")
    public void myPointcut() {

    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
                + mapper.writeValueAsString(array));
        Object object = pjp.proceed();
        log.info(className + " : " + methodName + "()" + "Response : "
                + mapper.writeValueAsString(object));
        return object;
    }

}