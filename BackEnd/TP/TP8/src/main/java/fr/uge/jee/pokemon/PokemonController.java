package fr.uge.jee.pokemon;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PokemonController {
    private static final PokemonService pokemonService = new PokemonService();
    Map<String, String> imagesmap = new HashMap<>();

    @GetMapping("/preferredpokemon")
    public String preferredPokemon(Model model) {
        model.addAttribute("name", new String());
        return "preferred-pokemon";
    }

    @PostMapping("/preferredpokemon")
    public String processForm(@Valid @ModelAttribute("name") String name, BindingResult result, Model model, HttpServletResponse response) throws IOException {
        if (result.hasErrors()) {
            return "preferred-pokemon";
        }
        pokemonService.insertOrIncrementPokemon(name);
        model.addAttribute("pokemons", pokemonService.getTopTen());
        return "preferred-pokemon-result";
    }
}
