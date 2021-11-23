package fr.uge.jee.springmvc.pokematch;

import io.netty.handler.codec.base64.Base64Encoder;
import org.apache.tomcat.util.http.fileupload.IOUtils;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PokemonController {
    private static final PokemonList pokelist = new PokemonList();
    Map<String, String> imagesmap = new HashMap<>();

    @GetMapping("/preferredpokemon")
    public String preferredPokemon(Model model) {
        model.addAttribute("name", new Name());
        return "preferred-pokemon";
    }

    @PostMapping("/preferredpokemon")
    public String processForm(@Valid @ModelAttribute("name") Name name, BindingResult result, Model model, HttpServletResponse response) throws IOException {
        if (result.hasErrors()) {
            return "preferred-pokemon";
        }
        Pokemon pokemon = pokelist.getPokemonFromName(name.getFirstName() + name.getLastName());
        pokemon.setCounter();
        model.addAttribute("pokemon",pokemon.getName());
        model.addAttribute("counter", pokemon.getCounter());
        String pokeimage = pokemon.getSprites().getFront_default();
        if (imagesmap.get(pokeimage) == null) {
            WebClient webClient = WebClient.create();
            imagesmap.put(pokeimage, Base64.getEncoder().encodeToString(webClient.get().uri(pokeimage).accept(MediaType.IMAGE_JPEG).retrieve()
                    .bodyToMono(byte[].class).block()));

        }
        model.addAttribute("pokeimage", imagesmap.get(pokeimage));
        model.addAttribute("pokemons", pokelist.getTopTen());
        return "preferred-pokemon-result";
    }
}
