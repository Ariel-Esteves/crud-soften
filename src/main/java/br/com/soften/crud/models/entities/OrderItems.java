package br.com.soften.crud.models.entities;

import br.com.soften.crud.models.entities.pk.OrderItemsPk;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderItems implements Serializable {

    @EmbeddedId
    private OrderItemsPk id;

    private double totalValue;



    public OrderItems(Sales sale, Client client) {

        id.setSales(sale);
        id.setClient(client);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItems that = (OrderItems) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Sales getSales(){
        return id.getSales();
    }

    public void setSales( Sales sales){
        id.setSales(sales);
    }

    public Client getClient(){
        return id.getClient();
    }

    public void setClient(Client client){
        id.setClient(client);
    }

}
