package fr.uge.jee.springmvc.pokematch;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PokemonApi {
    private List<Pokemon> results = new ArrayList<>();
    private String next;

    public List<Pokemon> getResults() {
        return results;
    }

    public String getNext() {
        return next;
    }

    public void setResults(List<Pokemon> results) {
        for (var result : results) {
            this.results.add(result);
        }
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Pokemon get(long id) {
        return results.get((int) id);
    }
}
