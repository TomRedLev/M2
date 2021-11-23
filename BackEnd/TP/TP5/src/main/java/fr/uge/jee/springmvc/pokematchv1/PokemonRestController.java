package fr.uge.jee.springmvc.pokematchv1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PokemonRestController {
    private static final PokemonList POKEMONS_MAP = new PokemonList();

    @GetMapping("/pokemons/{id}")
    public Pokemon getPokemon(@PathVariable("id") long id) {
        var pokemon = POKEMONS_MAP.get(id);
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
