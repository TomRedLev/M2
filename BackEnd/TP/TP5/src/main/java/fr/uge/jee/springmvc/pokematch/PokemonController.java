package fr.uge.jee.springmvc.pokematch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PokemonController {
    private static final PokemonList pokelist = new PokemonList();
    @GetMapping("/preferredpokemon")
    public String preferredPokemon() {
        return "preferred-pokemon";
    }

    @PostMapping("/preferredpokemon")
    public String processForm(@ModelAttribute("name") String name, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "preferred-pokemon-error";
        }
        Pokemon pokemon = pokelist.getPokemonFromName(name);
        pokemon.setCounter();
        model.addAttribute("pokemon",pokemon.getName());
        model.addAttribute("counter", pokemon.getCounter());
        return "preferred-pokemon-result";
    }
}
