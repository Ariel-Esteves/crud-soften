package br.com.soften.crud.services;

import br.com.soften.crud.models.Dto.OrderSaleItemsDto;
import br.com.soften.crud.models.entities.OrderSaleItems;
import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.repositories.OrderSaleItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
public class OrderSaleItemsService {
    @Autowired
    private OrderSaleItemsRepository orderSaleItemsRepository;
    @Autowired
    private ProductService productService;

    public OrderSaleItems save(OrderSaleItemsDto data){
        Product prod = productService.findById(data.getProduct_id());
        data.setUnitaryValue(prod.getSaleValue());
        OrderSaleItems orderSale = OrderSaleItems.builder()
                .amount(data.getAmount())
                .unitaryValue(data.getUnitaryValue())
                .totalValue(data.getTotalValue())
                .product_id(prod)
                .build();
        return orderSaleItemsRepository.save(orderSale);

    }

    public Optional<OrderSaleItems> findById( long id ){ return orderSaleItemsRepository.findById(id); }


    public boolean delete(long id){
        Optional<OrderSaleItems> data = orderSaleItemsRepository.findById(id);
        if(data.isPresent()){
            orderSaleItemsRepository.delete( data.get() );
            return true;
        }else{
            return false;
        } }

    public List<OrderSaleItems> findAll(){return orderSaleItemsRepository.findAll();}

}
