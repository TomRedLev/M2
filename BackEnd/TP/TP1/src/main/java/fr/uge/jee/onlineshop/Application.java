package fr.uge.jee.onlineshop;

import fr.uge.jee.ex4.Library;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config-online.xml");
        //var onlineshop = context.getBean("onlineShop", OnlineShop.class);
        var onlineshop = context.getBean(OnlineShop.class);
        onlineshop.printDescription();
    }
}
