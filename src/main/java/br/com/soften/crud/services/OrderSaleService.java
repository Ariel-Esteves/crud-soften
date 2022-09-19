package br.com.soften.crud.services;

import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.Dto.OrderSaleDto;
import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.OrderSale;
import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.repositories.OrderSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderSaleService {

    private final OrderSaleRepository orderSaleRepository;
    private final ClientService clientService;
    private final OrderSaleItemsService orderSaleItemsService;
    private final UserService userService;

    @Autowired
    public OrderSaleService(OrderSaleRepository orderSale, ClientService client, OrderSaleItemsService orderItems, UserService user) {
        this.orderSaleRepository = orderSale;
        this.clientService = client;
        this.orderSaleItemsService = orderItems;
        this.userService = user;
    }

    public OrderSale save(OrderSaleDto dto) {
        User user = userService.findById(dto.getUser());
        Client client = clientService.findById(dto.getClient());
        OrderSale data = dto.toOrderSale(client, user);
        data.getOrderSaleItems().stream().forEach(orderSaleItemsService::save);
        BigDecimal total =
                data.getOrderSaleItems().stream()
                        .map(e -> e.getTotalValue())
                        .reduce((accumulator, element) -> accumulator.add(element)).get();

        data.setTotalValue(total);
        return orderSaleRepository.save(data);
    }

    public OrderSale save(OrderSale sale) {

        BigDecimal total =
                sale.getOrderSaleItems().stream().map(e -> e.getTotalValue())
                        .reduce((acumulator, element) -> acumulator.add(element))
                        .orElseThrow(() -> new ResourceNotFoundException("total is null"));

        sale.setTotalValue(total);

        return orderSaleRepository.save(sale);
    }

    public OrderSale findById(long id) {
        Optional<OrderSale> data = orderSaleRepository.findById(id);
        return data.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(long id) {
        orderSaleRepository.deleteById(id);
    }

    public List<OrderSale> findAll() {
        return orderSaleRepository.findAll();
    }

}
