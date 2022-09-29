package br.com.soften.crud.models.Dto;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderSaleItemsDto{

    private Long id;

    private Long product;

    private BigDecimal amount;

    private BigDecimal unitaryValue;

    private BigDecimal totalValue;
}
