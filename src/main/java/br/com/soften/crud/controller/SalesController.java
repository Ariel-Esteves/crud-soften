package br.com.soften.crud.controller;

import br.com.soften.crud.models.entities.Sales;
import br.com.soften.crud.repositories.SalesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
   private SalesRepository salesRepository;
    @RequestMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Sales> sales = salesRepository.findById(id);
        return ResponseEntity.ok(sales);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        salesRepository.deleteById(id);
    }
    @RequestMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<Sales> res = salesRepository.findAll();
        return ResponseEntity.ok(res);
    }

    @PostMapping(value="/save")
    public ResponseEntity<?> save(@RequestBody Sales sales){
        Sales res = salesRepository.save(sales);

        return ResponseEntity.ok(res);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Sales sales){
        Sales res = salesRepository.save(sales);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/relational")
    public ResponseEntity<?> relational(){
        List<Object> res = salesRepository.getRelationalTable();
        return ResponseEntity.ok(res);
    }



}
