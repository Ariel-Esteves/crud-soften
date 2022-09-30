package br.com.soften.crud.services;

import br.com.soften.crud.models.Dto.OrderSaleDto;
import br.com.soften.crud.models.Dto.OrderSaleItemsDto;
import br.com.soften.crud.models.entities.*;
import br.com.soften.crud.repositories.BudgetItemsRepository;
import br.com.soften.crud.repositories.OrderSaleItemsRepository;
import br.com.soften.crud.repositories.OrderSaleRepository;
import br.com.soften.crud.repositories.SalesBudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

;

@Service
public class SalesBudgetService {


    private final OrderSaleRepository orderSaleRepository;
    private final OrderSaleItemsRepository orderSaleItemsRepository;
    private final ClientService clientService;
    private final UserService userService;
    private final ProductService productService;
    private final SalesBudgetRepository salesBudgetRepository;
    private final BudgetItemsRepository budgetItemsRepository;
    @Autowired
    public SalesBudgetService( OrderSaleRepository orderSale, ClientService client, UserService user, OrderSaleItemsRepository orderItems, ProductService product, SalesBudgetRepository salesBudget, BudgetItemsRepository budgetItemsRepository){
        this.orderSaleRepository = orderSale;
        this.clientService = client;
        this.userService = user;
        this.orderSaleItemsRepository = orderItems;
        this.productService = product;
        this.salesBudgetRepository = salesBudget;
        this.budgetItemsRepository = budgetItemsRepository;
    }


    public SalesBudget save( OrderSaleDto saleDto ){
        Client client = clientService.find(saleDto.getClient());
        User user = userService.find(saleDto.getUser());
        List<OrderSaleItemsDto> items = saleDto.getOrderSaleItems();
        items.stream().filter(e -> e.getUnitaryValue() == null).forEach(e -> {
            e.setUnitaryValue(
                    productService.find(e.getProduct()).getSaleValue()
            );
        });
        items.stream().forEach(e -> e.setTotalValue(e.getUnitaryValue().multiply(e.getAmount())));
        BigDecimal total = items.stream().map(a -> a.getTotalValue()).reduce(( a, e ) -> a.add(e)).get();
        List<BudgetItems> budgetItems =
                items.stream().map(e -> {
                    Product product = productService.find(e.getProduct());
                    BudgetItems orderedItems =
                            BudgetItems.builder()
                                    .amount(e.getAmount())
                                    .unitaryValue(e.getUnitaryValue())
                                    .product(product)
                                    .totalValue(total)
                                    .build();
                    budgetItemsRepository.save(orderedItems);
                    return orderedItems;
                }).collect(Collectors.toList());


        SalesBudget sale =
                SalesBudget.builder() .budgetItems(budgetItems)
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
        return data.orElse(null);
    }

    public void delete( long id ){
        salesBudgetRepository.deleteById(id);
    }

    public List<SalesBudget> findAll( ){
        return salesBudgetRepository.findAll();
    }

    }


