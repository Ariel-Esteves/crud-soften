package br.com.soften.crud.controller;

import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController{

    @Autowired
    ProductService productService;

    @GetMapping("findbyid/{id}")
    public ResponseEntity<?> save(@PathVariable long id){
        Optional<?> product =productService.findById(id);
        return product.isPresent()? ResponseEntity.ok(product) : ResponseEntity.badRequest().build();
    }


    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody Product product){
        Product req = productService.save(product);
        return ResponseEntity.ok(req);
    }

    @PostMapping("put")
    public ResponseEntity<?> update(@RequestBody Product product){
        Product req = productService.save(product);
        return ResponseEntity.ok(req);
    }



    @GetMapping("/findall")
    public ResponseEntity<?> findall(){
        return ResponseEntity.ok(productService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable long id) { return ResponseEntity.ok(productService.delete(id)); }

}
