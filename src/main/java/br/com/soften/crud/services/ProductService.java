package br.com.soften.crud.services;

import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepo) {
        this.productRepository = productRepo;
    }


    public Product save(Product data) {
        return productRepository.save(data);
    }

    public Product findById(Long id) {
        Product obj = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return obj;
    }

    public List<Product> findByName(String data) {
        List<Product> obj = productRepository.findByNameContaining(data);
        return obj;
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
