package kg.attractor.fexam.service;

import kg.attractor.fexam.DTO.CommentDTO;
import kg.attractor.fexam.model.Comment;
import kg.attractor.fexam.repository.CommentRepository;
import kg.attractor.fexam.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public List<CommentDTO> getThisPlaceComments(int placeId){
        List<Comment> messages = commentRepository.findAllByPlaceId(placeId);
        List<CommentDTO> messageDTOList = new ArrayList<>();
        if(messages!=null) {
            for(Comment m: messages){
                String userLogin = userRepository.findUserById(m.getUserId()).getLogin();
                messageDTOList.add(CommentDTO.builder()
                        .id(m.getId())
                        .login(userLogin)
                        .content(m.getContent())
                        .date(m.getMessageDate())
                        .time(m.getMessageTime())
                        .build());
            }
            return messageDTOList;
        }
        return null;
    }
}
