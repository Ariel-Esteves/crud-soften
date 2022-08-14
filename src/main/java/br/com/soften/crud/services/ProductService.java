package br.com.soften.crud.services;

import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){ return productRepository.findAll(); }

    public Product save(Product product){return productRepository.save(product); }

    public Optional<Product> findById(long id){ return productRepository.findById(id);}

    public void deleteById(long id){productRepository.deleteById(id);}

}
