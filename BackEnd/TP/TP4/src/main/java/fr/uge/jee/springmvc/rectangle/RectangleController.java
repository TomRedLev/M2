package fr.uge.jee.springmvc.rectangle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RectangleController {
    @GetMapping("/rectangle")
    public String rectangleForm() {
        return "rectangle";
    }

    @PostMapping("/rectangle")
    public String processForm(@Valid @ModelAttribute("rectangle") Rectangle rectangle, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "rectangle-error";
        }
        /*
        if (rectangle.getHeight() < 0 || rectangle.getWidth() < 0) {
            return "rectangle-error";
        }
         */
        model.addAttribute("area", rectangle.area());
        return "rectangle-result";
    }
}
