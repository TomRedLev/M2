package fr.uge.jee.springmvc.pokematch;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PokemonRestController {
    private static final PokemonList POKEMONS_MAP = new PokemonList();

    @GetMapping("/pokemons/{id}")
    public Pokemon getPokemon(@PathVariable("id") long id) {
        var pokemon = POKEMONS_MAP.getList().get((int) id);
        if (pokemon==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No pokemon with id ("+id+")");
        } else {
            return pokemon;
        }
    }

    @GetMapping("/pokemons")
    public PokemonList getPokemon() {
        return POKEMONS_MAP;
    }
}
