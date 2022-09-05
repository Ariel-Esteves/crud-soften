package br.com.soften.crud.controller;

import br.com.soften.crud.models.Dto.OrderSaleItemsDto;
import br.com.soften.crud.models.entities.OrderSaleItems;
import br.com.soften.crud.services.OrderSaleItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordersaleitems")
public class OrderSaleItemsController {
    @Autowired
    OrderSaleItemsService orderItemsService;



    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody OrderSaleItemsDto orderItems){
        OrderSaleItems req = orderItemsService.save(orderItems);
        return ResponseEntity.ok(req);
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findall(){
        return ResponseEntity.ok(orderItemsService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable long id) { return ResponseEntity.ok(orderItemsService.delete(id)); }
}
