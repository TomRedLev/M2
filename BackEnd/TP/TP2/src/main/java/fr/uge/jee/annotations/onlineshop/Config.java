package fr.uge.jee.annotations.onlineshop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

/*
@Configuration
public class Config {
    @Bean
    Delivery standardDelivery() {
        var bean = new StandardDelivery();
        bean.setDelay(999);
        return bean;
    }

    @Bean
    Insurance returnInsurance() {
        var bean = new ReturnInsurance();
        bean.setEveryone(true);
        return bean;
    }

    @Bean
    Insurance theftInsurance() {
        return new TheftInsurance();
    }

    @Bean
    OnlineShop onlineShop() {
        var bean = new OnlineShop();
        bean.setName("AhMaZone");
        bean.setDeliveryOptions(Set.of(standardDelivery()));
        bean.setInsurances(Set.of(returnInsurance(), theftInsurance()));
        return bean;
    }
}
*/

// Question : Comment l'application trouve le bean de OnlineShop sans le o majuscule avec la configuration.
// Regarder Application et OnlineShop pour voir la question

@Configuration
@ComponentScan
public class Config {
}