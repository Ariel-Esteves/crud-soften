package br.com.soften.crud.controller;

import br.com.soften.crud.services.OrderSaleItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordersaleitems")
public class OrderSaleItemsController {


    public final OrderSaleItemsService orderItemsService;

    @Autowired
    public OrderSaleItemsController(OrderSaleItemsService orderItems) {
        this.orderItemsService = orderItems;
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findall() {
        return ResponseEntity.ok(orderItemsService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        orderItemsService.deleteById(id);
        return ResponseEntity.ok("item deleted");
    }
}
