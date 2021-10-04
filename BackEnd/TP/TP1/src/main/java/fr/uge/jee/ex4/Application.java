package fr.uge.jee.ex4;

import fr.uge.jee.ex3.MessagePrinter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config-4.xml");
        Library library = context.getBean("library", Library.class);
        System.out.println(library.toString());
    }
}