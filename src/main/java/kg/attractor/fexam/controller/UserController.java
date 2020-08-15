package kg.attractor.fexam.controller;

import kg.attractor.fexam.model.User;
import kg.attractor.fexam.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class UserController {
//    private final UserService userService;
    private final UserRepository userRepository;


    @GetMapping("/profile")
    public String userProfile(Model model, Principal principal){
//        var user = userService.getByEmail(principal.getName());
//        model.addAttribute("dto", user);
        return "profile";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        return "register";
    }

    @PostMapping("/register")
    public String registerPage(User user,
                               BindingResult validationResult,
                               RedirectAttributes attributes) {
        attributes.addFlashAttribute("dto", user);

        if(validationResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/register";
        }
//        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }
}
