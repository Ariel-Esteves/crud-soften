package br.com.soften.crud.services;

import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.entities.OrderSaleItems;
import br.com.soften.crud.repositories.OrderSaleItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderSaleItemsService{
    private final OrderSaleItemsRepository orderSaleItemsRepository;

    @Autowired
    public OrderSaleItemsService( OrderSaleItemsRepository orderItems ){
        this.orderSaleItemsRepository = orderItems;
    }

    public OrderSaleItems save( OrderSaleItems data ){
        return orderSaleItemsRepository.save(data);
    }

    public OrderSaleItems findById( long id ){
        Optional<OrderSaleItems> data = orderSaleItemsRepository.findById(id);
        return data.orElseThrow(( ) -> new ResourceNotFoundException(id));
    }

    public void delete( long id ){
        OrderSaleItems data = this.findById(id);
        orderSaleItemsRepository.delete(data);
    }

    public List<OrderSaleItems> findAll( ){
        return orderSaleItemsRepository.findAll();
    }
}
