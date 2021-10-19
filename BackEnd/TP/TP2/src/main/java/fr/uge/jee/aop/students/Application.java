package fr.uge.jee.aop.students;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.refresh();
        RegistrationService registrationService = (RegistrationService) context.getBean(RegistrationService.class);


        //RegistrationService registrationService = new RegistrationService();
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
