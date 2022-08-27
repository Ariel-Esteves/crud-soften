package br.com.soften.crud.controller;

import br.com.soften.crud.models.Dto.OrderItemsDto;
import br.com.soften.crud.models.entities.OrderItems;
import br.com.soften.crud.services.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orderitems")
public class OrderItemsController {
    @Autowired
    OrderItemsService orderItemsService;

    @GetMapping("findbyid/{id}")
    public ResponseEntity<?> save(@PathVariable long id){

    }


    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody OrderItemsDto orderItems){
        orderItemsService.findById(orderItems.getClient());
        return ResponseEntity.ok(req);
    }

    @PostMapping("put")
    public ResponseEntity<?> update(@RequestBody OrderItems orderItems){
        OrderItems req = orderItemsService.save(orderItems);
        return ResponseEntity.ok(req);
    }



    @GetMapping("/findall")
    public ResponseEntity<?> findall(){
        return ResponseEntity.ok(orderItemsService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable long id) { return ResponseEntity.ok(orderItemsService.delete(id)); }
}
