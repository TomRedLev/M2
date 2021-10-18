package fr.uge.jee.annotations.onlineshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StandardDelivery implements Delivery {
    private int delay;
    /*
    public StandardDelivery(@Value("999") int delay) {
        this.delay = delay;
    }
     */

    public StandardDelivery(@Value("${onlineshop.standarddelivery.delay}") int delay) {
        this.delay = delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String getDescription() {
        return "Standard Delivery with a delay of " + String.valueOf(delay) + " days";
    }
}
