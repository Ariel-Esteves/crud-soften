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

    @Column(length = 60)
    private String client;

    @Column(length = 60)
    private String product;

    @Column(scale = 5, precision = 2, nullable = false)
    private float amount;

    @Column(scale = 6 , precision = 2, nullable = false)
    private float unitaryValue;

    @Column(scale = 6, precision = 2, nullable = false)
    private float totalValue;

    @ManyToOne()
    @JoinColumn(name = "cadClient")
    private Client cadClient;

    @ManyToMany()
    private List<Product> products;
}
