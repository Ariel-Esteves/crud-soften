package br.com.soften.crud.models.Dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//talvez não seja a melhor forma de utilizar dto, mas no meio de tantas pesquisas que eu vi foi a forma como achei maior utilidade
public class OrderSaleDto{
    private Long id;

    private BigDecimal totalValue;

    private List<OrderSaleItemsDto> orderSaleItems;

    private Long client;

    private Long user;

}
