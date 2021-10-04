package fr.uge.jee.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config-3.xml");
        // Exercice 1 :
        //var printer = (SimpleMessagePrinter) context.getBean("mp");
        // Exercice 2 :
        //var printer = (MessagePrinter) context.getBean("mp");
        //printer.printMessage();
        // Exercice 3 :
        // 1 - L'implémentation de base est un design pattern Singleton. A VERIFIER
        MessagePrinter printer = context.getBean("printerServiceCount",MessagePrinter.class);
        printer.printMessage();
        printer.printMessage();
        printer.printMessage();
        MessagePrinter printer2 =  context.getBean("printerServiceCount",MessagePrinter.class);
        printer2.printMessage();
    }
}