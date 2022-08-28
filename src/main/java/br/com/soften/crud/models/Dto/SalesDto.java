package br.com.soften.crud.models.Dto;

import br.com.soften.crud.models.entities.OrderItems;
import br.com.soften.crud.models.entities.Product;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


@Data
public class SalesDto {



    private long id;

    private BigDecimal totalValue;

    private Set<Long> orderedItems;


}
