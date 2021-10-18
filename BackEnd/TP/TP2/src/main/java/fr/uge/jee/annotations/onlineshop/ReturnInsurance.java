package fr.uge.jee.annotations.onlineshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReturnInsurance implements Insurance {
    private boolean everyone;

    /*
    public ReturnInsurance(@Value("true") boolean everyone) {
        this.everyone = everyone;
    }
    */

    public ReturnInsurance(@Value("${onlineshop.returninsurance.everyone}") boolean everyone) {
        this.everyone = everyone;
    }

    public void setEveryone(boolean everyone) {
        this.everyone = everyone;
    }

    @Override
    public String getDescription() {
        if (everyone) {
            return "Return insurance";
        }
        return "Return insurance only for members";
    }
}
