package br.com.soften.crud.controller;

import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController{

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody Product product){
        Product save = productService.save(product);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<Product> product = productService.findAll();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        Optional<Product> res = productService.findById(id);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        productService.deleteById(id);
    }


}
