package br.com.soften.crud.repositories;

import br.com.soften.crud.models.entities.ProductRegistration;
import br.com.soften.crud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductRegistration, Long> {

}
