package br.com.soften.crud.controller;

import br.com.soften.crud.models.Dto.OrderSaleDto;
import br.com.soften.crud.models.entities.OrderSale;
import br.com.soften.crud.services.OrderSaleItemsService;
import br.com.soften.crud.services.OrderSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ordersales")
public class OrderSalesController{
    @Autowired
    private OrderSaleService orderSaleService;

    @PostMapping("/save")
    public ResponseEntity<?> save( @RequestBody OrderSaleDto item ){
        OrderSale data = orderSaleService.save(item);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/save").buildAndExpand(data.getId()).toUri();
        return ResponseEntity.created(uri).body(data);
    }

    @RequestMapping("/find/{id}")
    public ResponseEntity<?> findById( @PathVariable Long id ){
        OrderSale sales = orderSaleService.findById(id);
        return ResponseEntity.ok(sales);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById( @PathVariable Long id ){
        orderSaleService.delete(id);
    }

    @RequestMapping("/findall")
    public ResponseEntity<?> findAll( ){
        List<OrderSale> res = orderSaleService.findAll();
        return ResponseEntity.ok(res);
    }


}
