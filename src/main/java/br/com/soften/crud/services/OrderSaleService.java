package br.com.soften.crud.services;

import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.Dto.OrderSaleDto;
import br.com.soften.crud.models.Dto.OrderSaleItemsDto;
import br.com.soften.crud.models.entities.*;
import br.com.soften.crud.repositories.OrderSaleItemsRepository;
import br.com.soften.crud.repositories.OrderSaleRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderSaleService{

    private final OrderSaleRepository orderSaleRepository;
    private final OrderSaleItemsRepository orderSaleItemsRepository;
    private final ClientService clientService;
    private final UserService userService;
    private final ProductService productService;
    private final SalesBudgetService salesBudgetService;

    @Autowired
    public OrderSaleService( OrderSaleRepository orderSale, ClientService client, UserService user, OrderSaleItemsRepository orderItems, ProductService product, SalesBudgetService salesBudget ){
        this.orderSaleRepository = orderSale;
        this.clientService = client;
        this.userService = user;
        this.orderSaleItemsRepository = orderItems;
        this.productService = product;
        this.salesBudgetService = salesBudget;
    }

    public OrderSale save( OrderSaleDto saleDto ){
        Client client = clientService.findById(saleDto.getClient());
        User user = userService.findById(saleDto.getUser());
        List<OrderSaleItemsDto> items = saleDto.getOrderSaleItems();
        items.stream().filter(e -> e.getUnitaryValue() == null).forEach(e -> {
            e.setUnitaryValue(
                    productService.findById(e.getProduct()).getSaleValue()
            );
        });
        items.stream().forEach(e -> e.setTotalValue(e.getUnitaryValue().multiply(e.getAmount())));
        BigDecimal total = items.stream().map(a -> a.getTotalValue()).reduce(( a, e ) -> a.add(e)).get();
        List<OrderSaleItems> orderSaleItems =
                items.stream().map(e -> {
            Product product = productService.findById(e.getProduct());
            OrderSaleItems orderedItems =
                    OrderSaleItems.builder()
                    .amount(e.getAmount())
                    .unitaryValue(e.getUnitaryValue())
                    .product(product)
                    .totalValue(total)
                    .build();
            orderSaleItemsRepository.save(orderedItems);
            return orderedItems;
        }).collect(Collectors.toList());


        OrderSale sale =
                OrderSale.builder()
                        .orderSaleItems(orderSaleItems)
                        .totalValue(total)
                        .user(user)
                        .client(client)
                        .build();
        if (saleDto.getId() != null) {
            sale.setId(saleDto.getId());
            return orderSaleRepository.save(sale);
        }
        return orderSaleRepository.save(sale);
    }
    public OrderSale ImportBudget( long id ){
        SalesBudget budget = salesBudgetService.findById(id);
        OrderSale orderSale =
                OrderSale.builder()
                .client(budget.getClient())
                .orderSaleItems(budget.getOrderSaleItems())
                .totalValue(budget.getTotalValue())
                .user(budget.getUser())
                .build();
    return orderSaleRepository.save(orderSale);}

    public OrderSale findById( long id ){
        Optional<OrderSale> data = orderSaleRepository.findById(id);
        return data.orElseThrow(( ) -> new ResourceNotFoundException(id));
    }

    public void delete( long id ){
        orderSaleRepository.deleteById(id);
    }

    public List<OrderSale> findAll( ){
        return orderSaleRepository.findAll();
    }

}
