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
    private long id;

    @Column(length = 60, nullable = false, insertable = false, updatable = false)
    private String client;

    @Column(scale = 4, precision = 10, nullable = false)
    private String product;

    @Column(scale = 4, precision = 10, nullable = false)
    private float amount;

    @Column(scale = 4 , precision = 10, nullable = false)
    private float unitaryValue;

    @Column(scale = 4, precision = 10, nullable = false)
    private float totalValue;

    @ManyToOne
    private Product product_id;

    @ManyToOne
    private Client client_id;

  /*  @ManyToMany
    @JoinTable(name = "order_products")
    private Set<Product> products = new HashSet<>(); */
}
