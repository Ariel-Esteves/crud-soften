package br.com.soften.crud.models.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(precision = 10, scale = 4, nullable = false)
    private BigDecimal costValue;

    @Column(precision = 10, scale = 4, nullable = false)
    private BigDecimal saleValue;

    @JoinColumn(nullable = false)
    @ManyToOne
    private User user;
}
