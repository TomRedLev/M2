package fr.uge.jee.aop.students;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

// On indique à cette classe les annotations @Aspect et @Component
@Aspect
@Component
public class RegistrationAspect {
    List<Long> lst_time_load = new ArrayList<>();
    List<Long> lst_time_save = new ArrayList<>();

    // Ceci est la première version d'une fonction étant appelé avant l'exécution d'une autre.
    /*
    @Before(value="execution(* fr.uge.jee.aop.students.RegistrationService.create*(..))")
    public void beforeCreate(JoinPoint jp) throws Throwable {
        System.out.println("Before create");
    }
     */

    // Version améliorée qui permet de récupérer le nom et les arguments de la fonction concernée.
    @Before(value="execution(* fr.uge.jee.aop.students.RegistrationService.create*(..))")
    public void beforeCreate(JoinPoint jp) throws Throwable {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (var arg : jp.getArgs()) {
            joiner.add(arg.toString());
        }
        System.out.println("Calling " + jp.getSignature().getName() + " with arguments : " + joiner.toString());
    }

    // Ceci est la première version d'une fonction étant appelé après l'exécution d'une autre.
    /*
    @After(value="execution(* fr.uge.jee.aop.students.RegistrationService.create*(..))")
    public void afterCreate(JoinPoint jp) throws Throwable {
        System.out.println("After create");
    }
     */

    // Version améliorée qui permet de récupérer la valeur de retour de la fonction concernée.
    @AfterReturning(value="execution(* fr.uge.jee.aop.students.RegistrationService.create*(..))", returning="value")
    public void afterCreate(JoinPoint jp, Object value) throws Throwable {
        System.out.println("Return id " + value + " by " + jp.getSignature().getName());
    }


    // Fonction qui calcule autour des fonctions *DB les temps d'exécution et qui les ajoute dans les listes souhaitées.
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

    // Fonction qui affiche à la fin de l'exécution du programme un rapport des temps d'exécutions des fonctions DB.
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
