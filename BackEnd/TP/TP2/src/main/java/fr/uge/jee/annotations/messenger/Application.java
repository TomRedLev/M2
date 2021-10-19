package fr.uge.jee.annotations.messenger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(Application.class);
        var messenger = applicationContext.getBean(Messenger.class);
        messenger.send("Hello !");

        // On peut utiliser la commande suivante pour exécuter le programme, via le terminal :
        // export MESSENGER_TOKEN=A123G32G234H34245234
        // mvn exec:java -Dexec.mainClass="fr.uge.jee.annotations.messenger.Application"
    }
}
