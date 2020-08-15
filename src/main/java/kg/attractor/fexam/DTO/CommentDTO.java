package kg.attractor.fexam.DTO;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentDTO {
    private Integer id;
    private String login;
    private String content;
    private LocalDate date;
    private LocalTime time;
}
