package fr.uge.jee.aop.students;

import fr.uge.jee.annotations.onlineshop.Config;
import fr.uge.jee.annotations.onlineshop.OnlineShop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        RegistrationService rs = (RegistrationService) context.getBean(RegistrationService.class);

        RegistrationService registrationService = new RegistrationService();
        registrationService.loadFromDB();
        long idHarry = registrationService.createStudent("Harry","Potter");
        long idHermione = registrationService.createStudent("Hermione","Granger");
        long idRon = registrationService.createStudent("Ron","Wesley");
        registrationService.saveToDB();
        long idPotions = registrationService.createLecture("Potions");
        registrationService.register(idHarry,idPotions);
        registrationService.register(idHermione,idPotions);
        registrationService.register(idRon,idPotions);
        registrationService.saveToDB();
        long idMalfoy = registrationService.createStudent("Draco","Malfoy");
        registrationService.saveToDB();
        registrationService.loadFromDB();
        long idDetention = registrationService.createLecture("Detention");
        registrationService.register(idHarry,idDetention);
        registrationService.register(idMalfoy,idDetention);

        registrationService.printReport();


    }



}
