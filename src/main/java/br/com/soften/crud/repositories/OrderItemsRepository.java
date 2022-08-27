package br.com.soften.crud.repositories;

import br.com.soften.crud.models.entities.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {

}
