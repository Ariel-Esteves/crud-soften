package br.com.soften.crud.controller;

import br.com.soften.crud.models.entities.Product;

import br.com.soften.crud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController{

    @Autowired
    ProductService productService;


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product data){
        Product cad = productService.save(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/save").buildAndExpand(data.getId()).toUri();
        return ResponseEntity.created(uri).body(data);
    }

    @GetMapping("findbyid/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = productService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.ok("Product id" + id + "erased");
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<Product> data = productService.findAll();
        return ResponseEntity.ok(data);
    }
    @GetMapping("findbyname/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        List<Product> obj = productService.findByName(name);
        return ResponseEntity.ok(obj);
    }
}
