package kg.attractor.fexam.controller;

import kg.attractor.fexam.repository.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@AllArgsConstructor
public class MainController {
    private final PlaceRepository placeRepository;
    @GetMapping("/")
    public String getMainPage(Model model){
        model.addAttribute("places", placeRepository.findAll());
        return "main_page";
    }
}
