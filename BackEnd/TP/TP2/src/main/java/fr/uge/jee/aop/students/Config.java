package fr.uge.jee.aop.students;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("fr.uge.jee.aop.students")
@EnableAspectJAutoProxy
public class Config {
}
