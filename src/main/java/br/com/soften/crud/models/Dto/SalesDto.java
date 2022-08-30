package br.com.soften.crud.models.Dto;

import br.com.soften.crud.models.entities.OrderItems;
import br.com.soften.crud.models.entities.Product;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;


@Data
public class SalesDto {



    private long id;

    @DecimalMax(value = "999999.9999")
    private BigDecimal totalValue;

    @NotNull
    private Set<Long> orderedItems;


}
