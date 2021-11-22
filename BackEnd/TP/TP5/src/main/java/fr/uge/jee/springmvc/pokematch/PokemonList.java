package fr.uge.jee.springmvc.pokematch;

import org.springframework.aop.config.PointcutEntry;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

public class PokemonList {
    private PokemonApi pokemonList;

    public PokemonList() {
        WebClient webClient = WebClient.create();
        this.pokemonList = webClient.get()
                .uri("https://pokeapi.co/api/v2/pokemon")
                .retrieve()
                .bodyToMono(PokemonApi.class)
                .block();
        while (pokemonList.getNext() != null) {
            PokemonApi tmp = webClient.get()
                    .uri(pokemonList.getNext())
                    .retrieve()
                    .bodyToMono(PokemonApi.class)
                    .block();
            
            if (tmp != null) {
                pokemonList.setResults(tmp.getResults());
                pokemonList.setNext(tmp.getNext());
            }
        }
    }

    public Pokemon get(long id) {
        return pokemonList.get((int) id);
    }

    public List<Pokemon> getList() {
        return pokemonList.getResults();
    }

    public String getTopTen() {
        pokemonList.getResults().sort(Comparator.comparing(Pokemon::getCounter).reversed());
        var sj = new StringJoiner(", ");
        int i = 0;
        for (var pokemonItem : pokemonList.getResults()) {
            sj.add(pokemonItem.getName() + " : " + pokemonItem.getCounter());
            if (i == 10) {
                break;
            }
            i++;
        }
        return sj.toString();
    }

    public Pokemon getPokemonFromName(String name) {
        int hash = name.hashCode();
        int min = 0;
        Pokemon pokemonfinal = new Pokemon();
        for (var pokemon : pokemonList.getResults()) {
            if (hash - min > hash - pokemon.getName().hashCode()) {
                min = pokemon.getName().hashCode();
                pokemonfinal = pokemon;
            }
        }
        return pokemonfinal;
    }
}