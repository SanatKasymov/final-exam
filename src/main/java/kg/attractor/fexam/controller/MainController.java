package kg.attractor.fexam.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@AllArgsConstructor
public class MainController {

    @GetMapping("/")
    public String getMainPage(Model model){
        return "main_page";
    }
}
