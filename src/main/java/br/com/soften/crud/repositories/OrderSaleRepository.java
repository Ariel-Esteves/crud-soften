package br.com.soften.crud.repositories;

import br.com.soften.crud.models.entities.OrderSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSaleRepository extends JpaRepository<OrderSale, Long>{
   // List<OrderSale> findByClientContaining( Client client);
}


