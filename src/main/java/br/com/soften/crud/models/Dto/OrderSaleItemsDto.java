package br.com.soften.crud.models.Dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderSaleItemsDto {

    private BigDecimal amount;

    private long product_id;

}