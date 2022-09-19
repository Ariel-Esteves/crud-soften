package br.com.soften.crud.models.Dto;

import br.com.soften.crud.models.entities.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class SalesBudgetDto{

    private Long id;


    private BigDecimal totalValue;


    private List<OrderSaleItems> orderSaleItems = new ArrayList<>();

    private Long user;

    private Long client;

    public SalesBudget toBudget( Client client, User user ){
        return new SalesBudget(id, totalValue, orderSaleItems, client, user );
    }
}