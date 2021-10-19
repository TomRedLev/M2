package fr.uge.jee.aop.students;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


// On applique les annotations @Configuration et @ComponentScan pour "indiquer" la classe de configuration
// On utilise @EnableAspectJAutoProxy pour activer les annotations
@Configuration
@ComponentScan("fr.uge.jee.aop.students")
@EnableAspectJAutoProxy
public class Config {
}
