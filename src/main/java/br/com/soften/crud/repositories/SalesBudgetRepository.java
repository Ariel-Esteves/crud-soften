package br.com.soften.crud.repositories;
import br.com.soften.crud.models.entities.SalesBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesBudgetRepository extends JpaRepository<SalesBudget, Long>{
}

