package fr.uge.jee.annotations.onlineshop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        var onlineshop = context.getBean("onlineShop", OnlineShop.class);
        onlineshop.printDescription();
    }
}
