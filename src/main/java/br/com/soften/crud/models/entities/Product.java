package br.com.soften.crud.models.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(scale = 4, precision = 10, nullable = false, columnDefinition = "Decimal(10,4) default '0.00'")
    private float costValue;

    @Column(scale = 4, precision = 10, nullable = false)
    private float saleValue;

    @OneToMany
    private Set<Sales> sales = new HashSet<>();
   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "order_id", insertable = false, updatable = false),
            @JoinColumn(name = "test_id", insertable = false, updatable = false)
    })*/


   // @ManyToOne
  //  private Order test;
   /* @ManyToMany(mappedBy = "products")
    private Set<Sales> sales = new HashSet<>(); */

}
