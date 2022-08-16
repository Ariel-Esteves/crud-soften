package br.com.soften.crud.controller;

import br.com.soften.crud.models.entities.Sales;
import br.com.soften.crud.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
   private SalesService salesService;

    @RequestMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Sales> sales = salesService.findById(id);
        return ResponseEntity.ok(sales);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        salesService.deleteById(id);
    }
    @RequestMapping("/getall")
    public ResponseEntity<?> findAll(){
        List<Sales> res = salesService.findAll();
        return ResponseEntity.ok(res);
    }

    @PostMapping(value="/save", consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody Sales sales){
        Sales res = salesService.save(sales);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Sales sales){
        Sales res = salesService.save(sales);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<?> findByContainingCadClient(@RequestBody String name){
        List<Sales> sales = salesService.findByCadClientContaining(name);
        return ResponseEntity.ok(sales);
    }
}
