package br.com.soften.crud.services;
import br.com.soften.crud.exceptions.ArgNullFoundException;
import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.Dto.OrderSaleDto;
import br.com.soften.crud.models.entities.*;
import br.com.soften.crud.models.entities.OrderSale;
import br.com.soften.crud.repositories.OrderSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderSaleService {

    @Autowired
    private OrderSaleRepository orderSaleRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderSaleItemsService orderSaleItemsService;
    
    public OrderSale save(OrderSaleDto data){
        Client client = clientService.findById(data.getClient());
       List<OrderSaleItems> items =
               data.getOrderSaleItems().stream()
                .map(orderSaleItemsService::findById)
                .collect(Collectors.toList());
       Optional<BigDecimal> total = items.stream()
               .map(e -> e.getTotalValue())
               .reduce((e,acumulator)-> acumulator.add(e));


        if(total.isPresent()){
            return OrderSale.builder()
                    .OrderSaleItems(items)
                    .totalValue(total.get())
                    .client(client).build();
        }else {
            throw new ArgNullFoundException();
        }

    }

    public OrderSale findById( long id ){
        Optional<OrderSale> data = orderSaleRepository.findById(id);
        return data.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public void delete(long id){
        OrderSale data = this.findById(id);
        orderSaleRepository.delete(data);
        }

    public List<OrderSale> findAll(){return orderSaleRepository.findAll();}


}
