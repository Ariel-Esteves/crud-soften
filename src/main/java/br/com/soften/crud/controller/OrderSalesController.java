package br.com.soften.crud.controller;

import br.com.soften.crud.models.Dto.OrderSaleDto;
import br.com.soften.crud.models.entities.OrderSale;
import br.com.soften.crud.services.OrderSaleService;
import br.com.soften.crud.services.SalesBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ordersales")
public class OrderSalesController {

    private final OrderSaleService orderSaleService;
    private final SalesBudgetService salesBudgetService;

    @Autowired
    public OrderSalesController(OrderSaleService orderSaleService, SalesBudgetService salesBudget) {
        this.orderSaleService = orderSaleService;
        this.salesBudgetService = salesBudget;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody OrderSaleDto item) {
        OrderSale data = orderSaleService.save(item);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/save").buildAndExpand(data.getId()).toUri();
        return ResponseEntity.created(uri).body(data);
    }

    @RequestMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        OrderSale sales = orderSaleService.findById(id);
        return ResponseEntity.ok(sales);
    }

    @PostMapping("/convert/{id}")
    public ResponseEntity<?> importBudget( @PathVariable Long id ){
        OrderSale budget = orderSaleService.ImportBudget(id);
        return ResponseEntity.ok(budget);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        orderSaleService.delete(id);
        return ResponseEntity.status(202).body("item " + id + " erased");
    }

    @RequestMapping("/findall")
    public ResponseEntity<?> findAll() {
        List<OrderSale> res = orderSaleService.findAll();
        return ResponseEntity.ok(res);
    }


}
