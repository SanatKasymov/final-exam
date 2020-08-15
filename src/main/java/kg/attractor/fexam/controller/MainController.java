package kg.attractor.fexam.controller;

import kg.attractor.fexam.model.PageableExample;
import kg.attractor.fexam.repository.PlaceRepository;
import kg.attractor.fexam.service.PlaceService;
import kg.attractor.fexam.service.PropertiesService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "main_page";
    }


    private static String constructPageUri(String uri, int page, int size){
        return String.format("%s?page=%s&size=%s", uri, page, size);
    }
}
