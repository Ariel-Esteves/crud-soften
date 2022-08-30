package br.com.soften.crud.models.Dto;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.services.ClientService;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class OrderItemsDto {

    @NotNull
    private long client;

    //killBill
    @DecimalMax(value = "999999.9999")
    private BigDecimal amount;

    @DecimalMax(value = "999999.9999")
    private BigDecimal unitaryValue;

    @DecimalMax(value = "999999.9999")
    private BigDecimal totalValue;;

    @NotNull
    private long product_id;


}
