package kg.attractor.fexam.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128)
    private Integer placeId;

    @Column(length = 128)
    private Integer userId;

    @Column(length = 128)
    private String content;

    @Column
    private LocalDate messageDate;

    @Column
    private LocalTime messageTime;

}
