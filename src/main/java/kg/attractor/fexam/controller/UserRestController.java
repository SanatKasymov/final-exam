package kg.attractor.fexam.controller;

import kg.attractor.fexam.DTO.UserDTO;
import kg.attractor.fexam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
@AllArgsConstructor
public class UserRestController {
    private final UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String requestApproveDTOS(@RequestBody UserDTO userDTO, Principal principal) {
        userService.register(userDTO);
        return "success";
    }
}
