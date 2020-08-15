package kg.attractor.fexam.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128)
    private String name;

    @Column(length = 128)
    private String email;


    @Column(length = 128)
    private String login;

    @Column(length = 128)
    private String password;

    @Column(length = 128)
    @Builder.Default
    private String role = "USER";

    @Column
    @Builder.Default
    private boolean enabled = true;
}
