package br.com.soften.crud.services;

import br.com.soften.crud.exceptions.ResourceNotFoundException;;
import br.com.soften.crud.models.Dto.OrderSaleDto;
import br.com.soften.crud.models.Dto.OrderSaleItemsDto;
import br.com.soften.crud.models.entities.*;
import br.com.soften.crud.repositories.OrderSaleItemsRepository;
import br.com.soften.crud.repositories.OrderSaleRepository;
import br.com.soften.crud.repositories.SalesBudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalesBudgetService {


    private final OrderSaleRepository orderSaleRepository;
    private final OrderSaleItemsRepository orderSaleItemsRepository;
    private final ClientService clientService;
    private final UserService userService;
    private final ProductService productService;
    private final SalesBudgetRepository salesBudgetRepository;
    @Autowired
    public SalesBudgetService( OrderSaleRepository orderSale, ClientService client, UserService user, OrderSaleItemsRepository orderItems, ProductService product, SalesBudgetRepository salesBudget){
        this.orderSaleRepository = orderSale;
        this.clientService = client;
        this.userService = user;
        this.orderSaleItemsRepository = orderItems;
        this.productService = product;
        this.salesBudgetRepository = salesBudget;
    }

    public SalesBudget save( OrderSaleDto saleDto ){
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


        SalesBudget sale =
                SalesBudget.builder()
                        .orderSaleItems(orderSaleItems)
                        .totalValue(total)
                        .user(user)
                        .client(client)
                        .build();
        if (saleDto.getId() != null) {
            sale.setId(saleDto.getId());
            return salesBudgetRepository.save(sale);
        }
        return salesBudgetRepository.save(sale);
    }

    public SalesBudget findById( long id ){
        Optional<SalesBudget> data = salesBudgetRepository.findById(id);
        return data.orElseThrow(( ) -> new ResourceNotFoundException(id));
    }

    public void delete( long id ){
        salesBudgetRepository.deleteById(id);
    }

    public List<SalesBudget> findAll( ){
        return salesBudgetRepository.findAll();
    }

    }


