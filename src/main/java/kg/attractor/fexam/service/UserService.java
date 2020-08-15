package kg.attractor.fexam.service;
import kg.attractor.fexam.DTO.UserDTO;
import kg.attractor.fexam.exception.UserAlreadyExistException;
import kg.attractor.fexam.exception.UserNotFoundException;
import kg.attractor.fexam.model.User;
import kg.attractor.fexam.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserDTO register(String name, String email, String login, String password){

        UserDTO userDTO = UserDTO.builder()
                .name(name)
                .email(email)
                .login(login)
                .password(password)
                .build();

        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw new UserAlreadyExistException();
        }
        var user = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .login(userDTO.getLogin())
                .password(encoder.encode(userDTO.getPassword()))
                .build();

        userRepository.save(user);

        return UserDTO.from(user);
    }

    public UserDTO getByEmail(String email){
        var user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);

        return UserDTO.from(user);
    }
}
