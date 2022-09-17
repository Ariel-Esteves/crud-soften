package br.com.soften.crud.services;

import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.Dto.OrderSaleDto;
import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.OrderSale;
import br.com.soften.crud.repositories.OrderSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderSaleService{

    @Autowired
    private OrderSaleRepository orderSaleRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderSaleItemsService orderSaleItemsService;

    public OrderSale save( OrderSaleDto dto ){
        Client client = clientService.findById(dto.getClient());
        OrderSale data = dto.toOrderSale(client);
        data.getOrderSaleItems().stream().forEach(orderSaleItemsService::save);
        BigDecimal total =
                data.getOrderSaleItems().stream()
                        .map(e -> e.getTotalValue())
                        .reduce(( accumulator, element ) -> accumulator.add(element)).get();

        data.setTotalValue(total);
        return orderSaleRepository.save(data);
    }

    public OrderSale findById( long id ){
        Optional<OrderSale> data = orderSaleRepository.findById(id);
        return data.orElseThrow(( ) -> new ResourceNotFoundException(id));
    }

    public void delete( long id ){
        OrderSale data = this.findById(id);
        orderSaleRepository.delete(data);
    }

    public List<OrderSale> findAll( ){
        return orderSaleRepository.findAll();
    }

}
