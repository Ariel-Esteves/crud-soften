package br.com.soften.crud.repositories;

import br.com.soften.crud.models.entities.OrderSaleItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSaleItemsRepository extends JpaRepository<OrderSaleItems, Long>{

}

