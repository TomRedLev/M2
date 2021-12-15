package fr.uge.jee.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PokemonService {
    @Autowired
    PokemonRepository pokemonRepository;
    @Autowired
    PokemonServiceWithFailure pokemonServiceWithFailure;
    @PersistenceUnit
    EntityManagerFactory emf;
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void insertOrIncrementPokemon(String name) {
        var pokemonToUpdate= em.find(Pokemon.class, name, LockModeType.PESSIMISTIC_WRITE);
        if (Objects.isNull(pokemonToUpdate)) {
            pokemonToUpdate = new Pokemon(name);
        } else {
            pokemonToUpdate.setScore(pokemonToUpdate.getScore()+1);
        }
        pokemonRepository.save(pokemonToUpdate);
    }

    @Transactional
    public void insertOrIncrementPokemonWithOptimisticLock(String name){
        var retry=true;
        while(retry) {
            retry=false;
            try {
                pokemonServiceWithFailure.insertOrIncrementPokemon(name);
            } catch (org.springframework.orm.ObjectOptimisticLockingFailureException e){
                retry=true;
            }
        }
    }

    public long totalCountVote() {
        var count = em.createQuery("SELECT sum(p.score) FROM Pokemon p", Long.class).getSingleResult();
        return count;
    }

    public List<Pokemon> getTopTen() {
        var pokemons = em.createQuery("SELECT p FROM Pokemon p ORDER BY p.score DESC", Pokemon.class).getResultList();
        return pokemons;
    }
}