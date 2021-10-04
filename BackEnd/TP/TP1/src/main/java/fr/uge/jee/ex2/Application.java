package fr.uge.jee.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config-2.xml");
        // Exercice 1 :
        //var printer = (SimpleMessagePrinter) context.getBean("mp");
        // Exercice 2 :
        var printer = (MessagePrinter) context.getBean("mp");
        printer.printMessage();
    }
}