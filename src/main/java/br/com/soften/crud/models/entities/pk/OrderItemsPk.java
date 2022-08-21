package br.com.soften.crud.models.entities.pk;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.Sales;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class OrderItemsPk implements Serializable {

    @ManyToOne
    private Sales sales;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemsPk)) return false;
        OrderItemsPk that = (OrderItemsPk) o;
        return sales.equals(that.sales) && client.equals(that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sales, client);
    }
}
