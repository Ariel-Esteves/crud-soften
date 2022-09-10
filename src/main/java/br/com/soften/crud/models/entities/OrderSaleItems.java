package br.com.soften.crud.models.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderSaleItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(scale = 4, precision = 10, nullable = false)
    private BigDecimal amount;

    @Column(scale = 4 , precision = 10, nullable = false)
    private BigDecimal unitaryValue;

    @Column(scale = 4 , precision = 10, nullable = false)
    private BigDecimal totalValue;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product_id;



}
