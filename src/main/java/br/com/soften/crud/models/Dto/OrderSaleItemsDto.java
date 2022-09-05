package br.com.soften.crud.models.Dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderSaleItemsDto {

    private BigDecimal amount;

    private BigDecimal unitaryValue;

    private BigDecimal totalValue;

    private long product_id;



    public OrderSaleItemsDto(long product, BigDecimal amount){
        this.product_id = product;
        this.amount = amount;
    }

    public BigDecimal getTotalValue(){
        return unitaryValue.multiply(amount);
    }


}
