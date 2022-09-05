package br.com.soften.crud.controller;

import br.com.soften.crud.models.entities.OrderSale;

import br.com.soften.crud.services.OrderSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordersales")
public class OrderSalesController {
    @Autowired
   private OrderSaleService salesService;
    @RequestMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<OrderSale> sales = salesService.findById(id);
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
