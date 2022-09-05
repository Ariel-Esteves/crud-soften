package br.com.soften.crud.models.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class OrderSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(precision = 10, scale = 4)
    private BigDecimal totalValue;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderSalesItems")
    private Set<OrderSaleItems> OrderSaleItems;

    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;


}
