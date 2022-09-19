package br.com.soften.crud.services;

import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.Dto.SalesBudgetDto;
import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.OrderSale;
import br.com.soften.crud.models.entities.SalesBudget;
import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.repositories.SalesBudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SalesBudgetService{

    private final OrderSaleService orderSaleService;
    private final ClientService clientService;
    private final OrderSaleItemsService orderSaleItemsService;
    private final UserService userService;

    private final SalesBudgetRepository salesBudgetRepository;

    @Autowired
    public SalesBudgetService( OrderSaleService orderSale, ClientService client, OrderSaleItemsService orderItems, UserService user, SalesBudgetRepository salesBudget ){
        this.orderSaleService = orderSale;
        this.clientService = client;
        this.orderSaleItemsService = orderItems;
        this.userService = user;
        this.salesBudgetRepository = salesBudget;
    }

    public SalesBudget save( SalesBudgetDto dto ){
        Client client = dto.getClient() == null ? clientService.findById(1L) : clientService.findById(dto.getClient());
        User user = userService.findById(dto.getUser());
        SalesBudget data = dto.toBudget(client, user);
        data.getOrderSaleItems().stream().forEach(orderSaleItemsService::save);
        BigDecimal total =
                data.getOrderSaleItems().stream()
                        .map(e -> e.getTotalValue())
                        .reduce(( accumulator, element ) -> accumulator.add(element)).get();

        data.setTotalValue(total);
        return salesBudgetRepository.save(data);
    }

    public OrderSale TransformIntoSale( long id ){
        Optional<SalesBudget> data = salesBudgetRepository.findById(id);
        if (data.isPresent()) {
            SalesBudget temp = data.get();
            return orderSaleService.save(OrderSale.builder()
                    .orderSaleItems(temp.getOrderSaleItems())
                    .totalValue(temp.getTotalValue())
                    .client(temp.getClient())
                    .id(temp.getId())
                    .user(temp.getUser())
                    .build());
        }
    }

    public SalesBudget findById( long id ){
        Optional<SalesBudget> data = salesBudgetRepository.findById(id);
        return data.orElseThrow(( ) -> new ResourceNotFoundException(id));
    }

    public void delete( long id ){
        SalesBudget data = this.findById(id);
        salesBudgetRepository.delete(data);
    }

    public List<SalesBudget> findAll( ){
        return salesBudgetRepository.findAll();
    }

}
