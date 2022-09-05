package br.com.soften.crud.repositories;

import br.com.soften.crud.models.entities.OrderSaleItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSaleItemsRepository extends JpaRepository<OrderSaleItems, Long> {

}
