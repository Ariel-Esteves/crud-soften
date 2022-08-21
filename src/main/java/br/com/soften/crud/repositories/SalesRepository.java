package br.com.soften.crud.repositories;

import br.com.soften.crud.models.entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {


   @Query(
           value = "select * from set_products;",
           nativeQuery = true
   )
    public List<Object> getRelationalTable();


}
