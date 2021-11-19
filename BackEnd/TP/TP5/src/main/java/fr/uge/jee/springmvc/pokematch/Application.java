package fr.uge.jee.springmvc.pokematch;

import fr.uge.jee.springmvc.reststudents.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner printPokemon(ApplicationContext applicationContext) {
        WebClient webClient = WebClient.create();
        return args -> {
            Pokemon pokemon = webClient.get()
                    .uri("https://pokeapi.co/api/v2/pokemon/1")
                    .retrieve()
                    .bodyToMono(Pokemon.class)
                    .block();
            System.out.println(pokemon);
        };
    }

    @Bean
    public CommandLineRunner printPokemons(ApplicationContext applicationContext) {
        WebClient webClient = WebClient.create();
        return args -> {
            Map<Long, Pokemon> pokemons = webClient.get()
                    .uri("https://pokeapi.co/api/v2/pokemon")
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
            System.out.println(pokemons);
        };
    }
}