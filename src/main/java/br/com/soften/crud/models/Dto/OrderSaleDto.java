package br.com.soften.crud.models.Dto;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.OrderSale;
import br.com.soften.crud.models.entities.OrderSaleItems;
import br.com.soften.crud.models.entities.User;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderSaleDto{

    private Long id;


    private BigDecimal totalValue;


    private List<OrderSaleItems> orderSaleItems = new ArrayList<>();

    private Long user;

    private Long client;

    public OrderSale toOrderSale( Client client, User user ){
        return new OrderSale(id, totalValue, orderSaleItems, client, user );
    }
}