package br.com.soften.crud.services;
import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.entities.Product;
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

    public Product save(Product data){ return productRepository.save(data); }

    public Product findById( Long id ){
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Product> findByName( String data ){
        List<Product> obj = productRepository.findByNameContaining(data);
        if(obj.size() > 0){
            return obj;
        }else{
            throw new ResourceNotFoundException(obj);
        }
    }

    public Product delete(Long id) {
        Optional<Product> data = productRepository.findById(id);
        return data.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Product> findAll(){return productRepository.findAll();}
}
