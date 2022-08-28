package br.com.soften.crud.models.Dto;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.services.ClientService;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
public class OrderItemsDto {

    private long client;

    //killBill

    private BigDecimal amount;

    private BigDecimal unitaryValue;

    private BigDecimal totalValue;;

    private long product_id;


}
