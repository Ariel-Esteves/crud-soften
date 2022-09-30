package br.com.soften.crud.services;

import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserService userService;

    @Autowired
    public ProductService(ProductRepository productRepo, UserService userService) {
        this.productRepository = productRepo;
        this.userService = userService;
    }


    public Product save(Product data, long user_id) {
        User user = userService.find(user_id);
        data.setUser(user);
        return productRepository.save(data);
    }

    public Product find(Long id) {
        Product obj = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return obj;
    }

    public List<Product> find(String name) {
        List<Product> obj = productRepository.findByNameContaining(name);
        return obj;
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
