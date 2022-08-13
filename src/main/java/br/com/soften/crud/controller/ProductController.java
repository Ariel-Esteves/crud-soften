package br.com.soften.crud.controller;

import br.com.soften.crud.models.entities.ProductRegistration;
import br.com.soften.crud.repositories.ProductRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController{

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody ProductRegistration product){
        ProductRegistration save = productRepository.save(product);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/get")
    public ResponseEntity<?> findAll(){
        List<ProductRegistration> product = productRepository.findAll();
        return ResponseEntity.ok(product);
    }

}
