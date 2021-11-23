package fr.uge.jee.springmvc.pokematch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Controller
public class PokemonController {
    private static final PokemonList pokelist = new PokemonList();
    @GetMapping("/preferredpokemon")
    public String preferredPokemon(Model model) {
        model.addAttribute("name", new Name());
        return "preferred-pokemon";
    }

    @PostMapping("/preferredpokemon")
    public String processForm(@Valid @ModelAttribute("name") Name name, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "preferred-pokemon";
        }
        Pokemon pokemon = pokelist.getPokemonFromName(name.getFirstName() + name.getLastName());
        pokemon.setCounter();
        model.addAttribute("pokemon",pokemon.getName());
        model.addAttribute("counter", pokemon.getCounter());
        model.addAttribute("pokeimage", pokemon.getSprites().getFront_default());
        model.addAttribute("pokemons", pokelist.getTopTen());
        return "preferred-pokemon-result";
    }
}
