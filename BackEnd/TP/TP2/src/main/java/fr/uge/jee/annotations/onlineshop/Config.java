package fr.uge.jee.annotations.onlineshop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

// La première classe de configuration est la suivante :

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

// On possède donc la classe de configuration suivant lors de la dernière question de l'exercice 1  :
// On applique les annotations @Configuration et @ComponentScan pour "indiquer" la classe de configuration
@Configuration
@ComponentScan
public class Config {
}