package br.com.soften.crud.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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

    @Column( precision = 10, scale = 4,nullable = false, columnDefinition = "Decimal(10,4) default '0.00'")
    private BigDecimal costValue;

    @Column( precision = 10, scale = 4, nullable = false)
    private BigDecimal saleValue;


}
