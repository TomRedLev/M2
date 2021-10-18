package fr.uge.jee.aop.students;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RegistrationAspect {

    @Bean
    RegistrationAspect registrationAspect() {
        return new RegistrationAspect();
    }

    @Before(value="execution(* fr.uge.jee.aop.students.RegistrationService.create*(..))")
    public void beforeCreate(JoinPoint jp) throws Throwable {
        System.out.println("Before create");
    }

    @After(value="execution(* fr.uge.jee.aop.students.RegistrationService.create*(..))")
    public void afterCreate(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Before create");
    }
}
