package fr.uge.jee.springmvc.pokematch;

import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

public class PokemonList {
    private PokemonApi pokemonapi;
    private List<Pokemon> pokemons = new ArrayList<>();

    public PokemonList() {
        //WebClient webClient = WebClient.create();
        WebClient webClient = WebClient.builder().exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer
                                .defaultCodecs()
                                .maxInMemorySize(32 * 1024 * 1024))
                        .build())
                .build();
        this.pokemonapi = webClient.get()
                .uri("https://pokeapi.co/api/v2/pokemon")
                .retrieve()
                .bodyToMono(PokemonApi.class)
                .block();

        /*
        System.out.println(pokemonapi);
         */

        while (pokemonapi.getNext() != null) {
            PokemonApi tmp = webClient.get()
                    .uri(pokemonapi.getNext())
                    .retrieve()
                    .bodyToMono(PokemonApi.class)
                    .block();
            
            if (tmp != null) {
                pokemonapi.setResults(tmp.getResults());
                pokemonapi.setNext(tmp.getNext());
            }

        }

        // Exercice 2 - Seconde evolution :

        var results = pokemonapi.getResults();
        for (var pokemonurl : results) {
            pokemons.add(webClient.get()
                    .uri(pokemonurl.getUrl())
                    .retrieve()
                    .bodyToMono(Pokemon.class)
                    .block());
        }
    }

    public List<Pokemon> getList() {
        return pokemons;
    }

    public String getTopTen() {
        pokemons.sort(Comparator.comparing(Pokemon::getCounter).reversed());
        var sj = new StringJoiner(", ");
        int i = 0;
        for (var pokemonItem : pokemons) {
            sj.add(pokemonItem.getName() + " : " + pokemonItem.getCounter());
            if (i == 10) {
                break;
            }
            i++;
        }
        return sj.toString();
    }

    public Pokemon getPokemonFromName(String name) {
        int hash = Math.abs(name.hashCode());
        int min = 0;
        Pokemon pokemonfinal = new Pokemon();
        for (var pokemon : pokemons) {
            int pokehash = Math.abs(pokemon.getName().hashCode());
            if ((hash - min) > (hash - pokehash) && (hash - pokehash) >= 0) {
                min = Math.abs(pokemon.getName().hashCode());
                pokemonfinal = pokemon;
            }
        }
        System.out.println(hash - min);
        return pokemonfinal;
    }
}
