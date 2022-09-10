package br.com.soften.crud.models.Dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;


@Getter
@Setter
@Builder
@NoArgsConstructor

public class OrderSaleDto {




    private List<Long> orderSaleItems;

    private long client;

     public OrderSaleDto(List<Long> lista, long client){
         lista.stream().forEach(orderSaleItems::add);
         this.client = client;
    }


}
