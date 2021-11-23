package fr.uge.jee.springmvc.pokematch;

import java.util.ArrayList;
import java.util.List;

public class PokemonApi {
    private List<PokemonURL> results = new ArrayList<>();
    private String next;

    public List<PokemonURL> getResults() {
        return results;
    }

    public String getNext() {
        return next;
    }

    public void setResults(List<PokemonURL> results) {
        for (var result : results) {
            this.results.add(result);
        }
    }

    public void setNext(String next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "PokemonApi{" +
                "results=" + results +
                ", next='" + next + '\'' +
                '}';
    }
}
