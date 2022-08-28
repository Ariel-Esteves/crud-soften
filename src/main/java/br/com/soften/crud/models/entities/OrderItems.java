package br.com.soften.crud.models.entities;

import br.com.soften.crud.models.entities.pk.OrderItemsPk;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderItems implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "client", foreignKey = @ForeignKey(name = "name"))
    private Client client;

    //killBill

    @Column(scale = 4, precision = 10, nullable = false)
    private BigDecimal amount;

    @Column(scale = 4 , precision = 10, nullable = false)
    private BigDecimal unitaryValue;

    @Column(scale = 4 , precision = 10, nullable = false)
    private BigDecimal totalValue;;

    @ManyToOne
    @JoinColumn
    private Product product_id;
}
