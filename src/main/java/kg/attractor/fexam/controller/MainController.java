package kg.attractor.fexam.controller;

import kg.attractor.fexam.model.PageableExample;
import kg.attractor.fexam.repository.PlaceRepository;
import kg.attractor.fexam.service.PlaceService;
import kg.attractor.fexam.service.PropertiesService;
import lombok.AllArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
@AllArgsConstructor
public class MainController {
    private final PlaceRepository placeRepository;
    private final PropertiesService propertiesService;
    private final PlaceService placeService;

    @GetMapping("/")
    public String getMainPage(Model model, Pageable pageable, HttpServletRequest uriBuilder){
        var places = placeRepository.findAll(pageable);
        var uri = uriBuilder.getRequestURI();
        var placeModel = model.addAttribute("places", placeService.findAllPLaces());
        PageableExample.constructPageable(places, propertiesService.getDefaultPageSize(), placeModel, uri);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();
        if(!userEmail.equals("anonymousUser")){
            model.addAttribute("authorized", true);
        }
        return "main_page";
    }

    @GetMapping("/places/{id:\\d+?}")
    public String placePage(@PathVariable int id, Model model){
        model.addAttribute("place", placeRepository.findById(id).get());
        return "place_page";
    }

}
