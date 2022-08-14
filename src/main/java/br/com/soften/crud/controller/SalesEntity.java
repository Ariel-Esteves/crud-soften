package br.com.soften.crud.controller;

import br.com.soften.crud.models.entities.Sales;
import br.com.soften.crud.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesEntity {

    @Autowired
    SalesService salesService;

    @RequestMapping("/getall")
    public ResponseEntity<?> findAll(){
        List<Sales> res = salesService.findAll();
        return ResponseEntity.ok(res);
    }

    @PostMapping(value="/save", consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody Sales req){
        Sales res = salesService.save(req);
        return ResponseEntity.ok(res);
    }
}
