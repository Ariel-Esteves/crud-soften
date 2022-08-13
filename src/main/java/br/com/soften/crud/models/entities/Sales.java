package br.com.soften.crud.models.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sales implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String client;

    @Column(scale = 4, precision = 2, nullable = false)
    private float product;

    @Column(scale = 4, precision = 2, nullable = false)
    private float amount;

    @Column(scale = 4 , precision = 2, nullable = false)
    private float unitaryValue;

    @Column(scale = 4, precision = 2, nullable = false)
    private float totalValue;
}
