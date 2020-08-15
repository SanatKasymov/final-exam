package kg.attractor.fexam.service;

import kg.attractor.fexam.DTO.CommentDTO;
import kg.attractor.fexam.model.Comment;
import kg.attractor.fexam.model.Place;
import kg.attractor.fexam.repository.CommentRepository;
import kg.attractor.fexam.repository.PlaceRepository;
import kg.attractor.fexam.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;

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

    public String createNewMessage(Integer placeId, String content, String userEmail, Integer ratingValue){
        Integer id = userRepository.findUserByEmail(userEmail).getId();
        commentRepository.save(Comment.builder()
                .placeId(placeId)
                .content(content)
                .userId(id)
                .ratingValue(ratingValue)
                .messageDate(LocalDate.now())
                .messageTime(LocalTime.now())
                .build());

        Place place = placeRepository.findById(placeId).get();
        place.setRating(placeRating(ratingValue, placeId));
        placeRepository.save(place);
        return "success";
    }

    public double placeRating(Integer placeRatingValue, Integer placeId){
        List<Comment> comments = commentRepository.findAllByPlaceId(placeId);
        double ratingSum = 0;
        int count = 1;
        if(comments!=null){
            for(int i=0; i<comments.size();i++){
                ratingSum = ratingSum + comments.get(i).getRatingValue();
                count++;
            }
            ratingSum = ratingSum + placeRepository.findById(placeId).get().getRating();
            return ratingSum/count;
        }else {
            return placeRepository.findById(placeId).get().getRating();
        }


    }

    public List<Integer> getValue(){
        List<Integer> intArray = new ArrayList<>();
        for(int i = 1; i<11; i++){
            intArray.add(i);
        }
        return intArray;
    }
}
