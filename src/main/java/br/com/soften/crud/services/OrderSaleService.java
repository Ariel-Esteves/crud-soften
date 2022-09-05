package br.com.soften.crud.services;
import br.com.soften.crud.models.Dto.OrderSaleDto;
import br.com.soften.crud.models.entities.*;
import br.com.soften.crud.models.entities.OrderSale;
import br.com.soften.crud.repositories.OrderSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderSaleService {

    @Autowired
    private OrderSaleRepository orderSaleRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderSaleItemsService orderSaleItemsService;
    
    public OrderSale save(OrderSaleDto data){
        Set<OrderSaleItems> saleItems = new HashSet<>();
        BigDecimal total = new BigDecimal(0);
        Client client = clientService.findById(data.getClient());
        data.getOrderedItems().stream().forEach((resource) -> {
            Optional<OrderSaleItems> resourceFromDto = orderSaleItemsService.findById(resource);
            saleItems.add(resourceFromDto.get());
            total.add(resourceFromDto.get().getTotalValue());
        });
        OrderSale dataToSave =
                OrderSale.builder()
                .client(client)
                .OrderSaleItems(saleItems)
                .totalValue(total)
                .build();

        return orderSaleRepository.save(dataToSave);
    }

    public boolean delete(long id){
        Optional<OrderSale> data = orderSaleRepository.findById(id);
        if(data.isPresent()){
            orderSaleRepository.delete( data.get() );
            return true;
        }else{
            return false;
        } }

    public List<OrderSale> findAll(){return orderSaleRepository.findAll();}

    public Optional<OrderSale> findById( long id ){ return orderSaleRepository.findById(id); }
}
