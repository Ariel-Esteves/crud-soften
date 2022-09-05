package br.com.soften.crud.models.Dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;


@Data
public class OrderSaleDto {



    private long id;

    private BigDecimal totalValue;

    private Set<Long> orderedItems;

    private long client;

    public OrderSaleDto(long client, Set<Long> orderedItems){
        this.client = client;
        this.orderedItems = orderedItems;
    }
}
