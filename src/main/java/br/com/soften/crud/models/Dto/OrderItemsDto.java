package br.com.soften.crud.models.Dto;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.services.ClientService;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class OrderItemsDto {

    private Client client;

    //killBill

    private float amount;

    private float unitaryValue;

    private float totalValue;;

    private long product_id;

    public OrderItemsDto(long client, long product_id) {

        this.unitaryValue = product_id.getSaleValue();
        this.totalValue = amount * unitaryValue;
        this.product_id = product_id;
    }
}
