package br.com.soften.crud.models.entities;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String login;

    @Column(length = 20, nullable = false)
    private String password;
}
