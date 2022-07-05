package com.finalproject.aspect;

import com.finalproject.models.OffensiveUser;
import com.finalproject.repository.OffensiveRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

@Aspect
@Component
@AllArgsConstructor
@Slf4j
public class WaaOffensiveWords {

    @Autowired
    private OffensiveRepo offensiveRepo;
    private final List<String> offWords = List.of("spring", "springboot");

    @Pointcut("within(com.finalproject.controllers..*)")
    public void checker(){}

    @Around("checker()")
    public Object checking(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        if (request.getRequestURI().equals("/api/v1/products") && request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
            var user = request.getUserPrincipal().getName();
            for (Object ob: proceedingJoinPoint.getArgs()) {
                for (String s : offWords) {
                    if (ob.toString().contains(s)) {
                        if(offensiveRepo.findByUserName(user)!=null) {
                            var old = offensiveRepo.findByUserName(user);
                            Class<?> someClass = ob.getClass();
                            Field field = someClass.getDeclaredField("name");
                            field.setAccessible(true);
                            field.set(ob, "******" + field.get(ob).toString().substring(3));
                            var totalCount = offensiveRepo.findByUserName(user).getCount();
                            old.setCount(++totalCount);
                            old.setRequestAt(LocalDateTime.now());
                            offensiveRepo.save(old);
                        } else {
                            Class<?> someClass = ob.getClass();
                            Field field = someClass.getDeclaredField("name");
                            field.setAccessible(true);
                            field.set(ob, "******" + field.get(ob).toString().substring(3));
                            OffensiveUser newOff = new OffensiveUser(1, LocalDateTime.now(), user);
                            offensiveRepo.save(newOff);
                        }
                    }
                }
            }
        }
        return proceedingJoinPoint.proceed();
    }
}
