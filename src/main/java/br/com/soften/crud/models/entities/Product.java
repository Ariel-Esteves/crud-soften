package br.com.soften.crud.models.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @ManyToMany()
    private List<Sales> sale;
}
