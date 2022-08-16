package br.com.soften.crud.models.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @Column(length = 60, nullable = false)
    private String client;

    @Column(scale = 4, precision = 10, nullable = false)
    private String product;

    @Column(scale = 4, precision = 10, nullable = false)
    private float amount;

    @Column(scale = 4 , precision = 10, nullable = false)
    private float unitaryValue;

    @Column(scale = 4, precision = 10, nullable = false)
    private float totalValue;

    @ManyToOne()
    @JoinColumn(name = "cadClient")
    private Client cadClient;

    @ManyToMany()
    private List<Product> products;
}
