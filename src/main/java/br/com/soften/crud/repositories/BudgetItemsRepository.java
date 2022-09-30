package br.com.soften.crud.repositories;

import br.com.soften.crud.models.entities.BudgetItems;
import br.com.soften.crud.models.entities.OrderSaleItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetItemsRepository extends JpaRepository<BudgetItems, Long>{

}

