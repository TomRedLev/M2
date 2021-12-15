package fr.uge.jee.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;

@Service
public class PokemonServiceWithFailure {
    @PersistenceUnit
    EntityManagerFactory emf;
    @PersistenceContext
    EntityManager em;
    @Autowired
    PokemonRepository pokemonRepository;

    @Transactional
    public void insertOrIncrementPokemon(String name) {
        var pokemonToUpdate= em.find(Pokemon.class, name, LockModeType.PESSIMISTIC_WRITE);
        if (pokemonToUpdate == null) {
            var pokemon = new Pokemon(name);
            pokemonRepository.save(pokemon);
        } else {
            pokemonToUpdate.setScore(pokemonToUpdate.getScore()+1);
            pokemonRepository.save(pokemonToUpdate);
        }
    }
}
