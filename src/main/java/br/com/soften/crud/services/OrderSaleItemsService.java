package br.com.soften.crud.services;

import br.com.soften.crud.exceptions.ResourceNotFoundException;
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
        Product product = productService.findById(data.getProduct_id());
        BigDecimal unitaryValue = data.getUnitaryValue() != null ? data.getUnitaryValue() : product.getSaleValue();
        return orderSaleItemsRepository.save(
                OrderSaleItems.builder()
                .product_id(product)
                .unitaryValue(product.getSaleValue())
                .amount(data.getAmount())
                        .totalValue(data.getAmount().multiply(unitaryValue))
                .build()
        );

    }

    public OrderSaleItems findById( long id ){
        Optional<OrderSaleItems> data = orderSaleItemsRepository.findById(id);
        return data.orElseThrow(()-> new ResourceNotFoundException(id));
    }


    public void delete(long id){
        OrderSaleItems data = this.findById(id);
        orderSaleItemsRepository.delete(data);
         }

    public List<OrderSaleItems> findAll(){return orderSaleItemsRepository.findAll();}

}
