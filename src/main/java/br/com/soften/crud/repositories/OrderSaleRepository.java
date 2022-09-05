package br.com.soften.crud.repositories;

import br.com.soften.crud.models.entities.OrderSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderSaleRepository extends JpaRepository<OrderSale, Long> {



}
