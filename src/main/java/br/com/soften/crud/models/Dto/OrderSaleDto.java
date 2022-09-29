package br.com.soften.crud.models.Dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderSaleDto{
    private Long id;

    private BigDecimal totalValue;

    private List<OrderSaleItemsDto> orderSaleItems;

    private Long client;

    private Long user;

}
