package fr.uge.jee.annotations.onlineshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Set;

@PropertySource("classpath:onlineshop.properties")
@Component
public class OnlineShop {

    private String name;
    @Autowired
    private Set<Delivery> deliveryOptions;
    @Autowired
    private Set<Insurance> insurances;

    /*
    public OnlineShop(@Value("AhMaZone") String name) {
        this.name = name;
    }
     */
    public OnlineShop(@Value("${onlineshop.name}") String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeliveryOptions(Set<Delivery> deliveryOptions) {
        this.deliveryOptions = deliveryOptions;
    }

    public void setInsurances(Set<Insurance> insurances) {
        this.insurances = insurances;
    }

    public void printDescription(){
        System.out.println(name);
        System.out.println("Delivery options");
        deliveryOptions.forEach(opt -> System.out.println("\t"+opt.getDescription()));
        System.out.println("Insurance options");
        insurances.forEach(insurance -> System.out.println("\t"+insurance.getDescription()));
    }
}
