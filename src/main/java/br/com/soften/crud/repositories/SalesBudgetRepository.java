package br.com.soften.crud.repositories;

import br.com.soften.crud.models.entities.OrderSale;
import br.com.soften.crud.models.entities.SalesBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesBudgetRepository extends JpaRepository<SalesBudget, Long>{
    List<OrderSale> findByClientContaining(String name);
}

