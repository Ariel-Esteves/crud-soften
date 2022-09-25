package br.com.soften.crud.controller;

import br.com.soften.crud.models.Dto.OrderSaleDto;
import br.com.soften.crud.models.entities.OrderSale;
import br.com.soften.crud.models.entities.SalesBudget;
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
public class SalesBudgetControler{

    private final OrderSaleService orderSaleService;
    private final SalesBudgetService salesBudgetService;

    @Autowired
    public SalesBudgetControler( OrderSaleService orderSaleService, SalesBudgetService salesBudget) {
        this.orderSaleService = orderSaleService;
        this.salesBudgetService = salesBudget;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody OrderSaleDto item) {
        SalesBudget data = salesBudgetService.save(item);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/save").buildAndExpand(data.getId()).toUri();
        return ResponseEntity.created(uri).body(data);
    }

    @RequestMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
       SalesBudget sales = salesBudgetService.findById(id);
        return ResponseEntity.ok(sales);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        salesBudgetService.delete(id);
    }

    @RequestMapping("/findall")
    public ResponseEntity<?> findAll() {
        List<SalesBudget> res = salesBudgetService.findAll();
        return ResponseEntity.ok(res);
    }


}
