package br.com.soften.crud.controller;

import br.com.soften.crud.models.Dto.OrderSaleDto;
import br.com.soften.crud.models.entities.OrderSale;

import br.com.soften.crud.services.OrderSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordersales")
public class OrderSalesController {
    @Autowired
   private OrderSaleService salesService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody OrderSaleDto data){
        OrderSale datasale = salesService.save(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/save").buildAndExpand(datasale.getId()).toUri();
        return ResponseEntity.created(uri).body(datasale);
    }
    @RequestMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        OrderSale sales = salesService.findById(id);
        return ResponseEntity.ok(sales);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        salesService.delete(id);
    }
    @RequestMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<OrderSale> res = salesService.findAll();
        return ResponseEntity.ok(res);
    }



}
