package fr.uge.jee.annotations.onlineshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TheftInsurance implements Insurance {
    public TheftInsurance() {}

    @Override
    public String getDescription() {
        return "Theft insurance";
    }
}
