package fr.uge.jee.servlet.rectanglesession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;

@Controller
public class RectangleController {
    private HashMap<String, String> map = new HashMap<>();
    @GetMapping("/rectanglesession")
    public String rectangleForm() {
        return "rectanglesession";
    }

    @PostMapping("/rectanglesession")
    public String processForm(@ModelAttribute("rectangle") Rectangle rectangle, HttpSession httpSession, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "rectanglesession-error";
        }
        if (rectangle.getHeight() < 0 || rectangle.getWidth() < 0) {
            return "rectanglesession-error";
        }
        if (map.get(httpSession.getId()) == null) {
            map.put(httpSession.getId(), String.valueOf(rectangle.area()));
        } else {
            map.put(httpSession.getId(), map.get(httpSession.getId()) + ", " + rectangle.area());
        }
        model.addAttribute("area", rectangle.area());
        model.addAttribute("areas", map.get(httpSession.getId()));
        return "rectanglesession-result";
    }
}
