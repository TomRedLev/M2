package fr.uge.jee.annotations.onlineshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Le component permet d'indiquer au conteneur IoC de générer un bean pour cette classe
@Component
public class ReturnInsurance implements Insurance {
    private boolean everyone;

    // On utilise l'annotation @PropertySource pour indiquer où se situe le dossier onlineshop.properties
    /*
    public ReturnInsurance(@Value("true") boolean everyone) {
        this.everyone = everyone;
    }
    */

    // On peut donc utiliser des annotations @Value en indiquant la variable que l'on souhaite utiliser et qui
    // se situe dans le fichier onlineshop.properties
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
