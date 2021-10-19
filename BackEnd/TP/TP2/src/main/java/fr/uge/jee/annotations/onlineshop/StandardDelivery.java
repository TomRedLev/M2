package fr.uge.jee.annotations.onlineshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Le component permet d'indiquer au conteneur IoC de générer un bean pour cette classe
@Component
public class StandardDelivery implements Delivery {
    private int delay;
    // On utilise l'annotation @PropertySource pour indiquer où se situe le dossier onlineshop.properties
    /*
    public StandardDelivery(@Value("999") int delay) {
        this.delay = delay;
    }
     */

    // On peut donc utiliser des annotations @Value en indiquant la variable que l'on souhaite utiliser et qui
    // se situe dans le fichier onlineshop.properties
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
