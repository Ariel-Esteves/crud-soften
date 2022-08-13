package br.com.soften.crud.services;

import br.com.soften.crud.models.entities.ProductRegistration;
import br.com.soften.crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


}
