package fr.uge.jee.annotations.messenger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Le component permet d'indiquer au conteneur IoC de générer un bean pour cette classe
@Component
public class Messenger {
    //@Value("A123G32G234H34245234")
    // On  indique la valeur d'environment à utiliser de la façon suivante
    @Value("#{environment.MESSENGER_TOKEN}")
    private String token;

    public void send(String message){
        System.out.println("Using the super secret token "+token+" to send the message : "+message);
    }
}
