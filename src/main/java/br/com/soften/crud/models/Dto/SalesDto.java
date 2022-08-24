package br.com.soften.crud.models.Dto;

import br.com.soften.crud.models.entities.Product;
import lombok.Data;

import java.util.Set;


@Data
public class SalesDto {


    private String client;

    private String product;

    private float amount;

    private float unitaryValue;

    private float totalValue;;

    private Set<Long> product_id;

    public SalesDto(String client, String product, float amount, float unitaryValue, Set<Long> product_id) {
        this.client = client;
        this.product = product;
        this.amount = amount;
        this.unitaryValue = unitaryValue;
        this.totalValue = amount * unitaryValue;
        this.product_id = product_id;
    }
}
