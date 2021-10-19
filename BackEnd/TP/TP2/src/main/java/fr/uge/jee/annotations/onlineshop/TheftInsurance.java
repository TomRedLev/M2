package fr.uge.jee.annotations.onlineshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Le component permet d'indiquer au conteneur IoC de générer un bean pour cette classe
@Component
public class TheftInsurance implements Insurance {
    public TheftInsurance() {}

    @Override
    public String getDescription() {
        return "Theft insurance";
    }
}
