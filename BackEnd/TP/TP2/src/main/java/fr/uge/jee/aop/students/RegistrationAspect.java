package fr.uge.jee.aop.students;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Aspect
@Component
public class RegistrationAspect {
    List<Long> lst_time_load = new ArrayList<>();
    List<Long> lst_time_save = new ArrayList<>();

    /*
    @Before(value="execution(* fr.uge.jee.aop.students.RegistrationService.create*(..))")
    public void beforeCreate(JoinPoint jp) throws Throwable {
        System.out.println("Before create");
    }
     */

    @Before(value="execution(* fr.uge.jee.aop.students.RegistrationService.create*(..))")
    public void beforeCreate(JoinPoint jp) throws Throwable {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (var arg : jp.getArgs()) {
            joiner.add(arg.toString());
        }
        System.out.println("Calling " + jp.getSignature().getName() + " with arguments : " + joiner.toString());
    }

    /*
    @After(value="execution(* fr.uge.jee.aop.students.RegistrationService.create*(..))")
    public void afterCreate(JoinPoint jp) throws Throwable {
        System.out.println("After create");
    }
     */

    @AfterReturning(value="execution(* fr.uge.jee.aop.students.RegistrationService.create*(..))", returning="value")
    public void afterCreate(JoinPoint jp, Object value) throws Throwable {
        System.out.println("Return id " + value + " by " + jp.getSignature().getName());
    }



    @Around(value="execution(* fr.uge.jee.aop.students.RegistrationService.*DB(..))")
    public void afterDB(ProceedingJoinPoint pjp) throws Throwable {
        long current_timer = System.currentTimeMillis();
        pjp.proceed();
        if (pjp.getSignature().getName().equals("loadFromDB")) {
            lst_time_load.add(System.currentTimeMillis() - current_timer);
        } else {
            lst_time_save.add(System.currentTimeMillis() - current_timer);
        }
    }

    @After(value="execution(* fr.uge.jee.aop.students.RegistrationService.printReport(..))")
    public void afterReport(JoinPoint jp) throws Throwable {
        System.out.println("DB timing report :");
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        double moy = 0;
        double cmpt = 0;
        for (var time_save : lst_time_save) {
            joiner.add(time_save.toString());
            moy += time_save;
            cmpt += 1;
        }
        System.out.println("\tSaveToDB\n\t\tMesured access times : " + joiner.toString() + "\n\t\tAverage time : " + moy / cmpt);
        joiner = new StringJoiner(",", "[", "]");
        moy = 0;
        cmpt = 0;
        for (var time_load : lst_time_load) {
            joiner.add(time_load.toString());
            moy += time_load;
            cmpt += 1;
        }
        System.out.println("\tLoadFromDB\n\t\tMesured access times : " + joiner.toString() + "\n\t\tAverage time : " + moy / cmpt);
    }
}
