package kg.attractor.fexam.controller;

import kg.attractor.fexam.DTO.CommentDTO;
import kg.attractor.fexam.model.PageableExample;
import kg.attractor.fexam.repository.PlaceRepository;
import kg.attractor.fexam.service.CommentService;
import kg.attractor.fexam.service.PlaceService;
import kg.attractor.fexam.service.PropertiesService;
import lombok.AllArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class MainController {
    private final PlaceRepository placeRepository;
    private final PropertiesService propertiesService;
    private final PlaceService placeService;
    private final CommentService commentService;

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
        List<CommentDTO> commentDTOS = commentService.getThisPlaceComments(id);
        model.addAttribute("place", placeRepository.findById(id).get());
        if(commentDTOS!=null){
            model.addAttribute("comments", commentDTOS);
        }else{
            model.addAttribute("comments", false);
        }
        return "place_page";
    }

    @GetMapping("/create_new_place")
    public String newPlacePage(Model model) {
        return "create_new_place";
    }

    @PostMapping("/create_new_place")
    public String rootSave(@RequestParam("place_name") String name, @RequestParam("place_description") String description,
                           @RequestParam("place_image") MultipartFile image) throws IOException {
        return placeService.addNewPlace(name, description, image);
    }
}
