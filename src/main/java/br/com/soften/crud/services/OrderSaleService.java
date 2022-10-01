package br.com.soften.crud.services;

import br.com.soften.crud.models.Dto.OrderSaleDto;
import br.com.soften.crud.models.Dto.OrderSaleItemsDto;
import br.com.soften.crud.models.entities.*;
import br.com.soften.crud.repositories.OrderSaleItemsRepository;
import br.com.soften.crud.repositories.OrderSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderSaleService {

    private final OrderSaleRepository orderSaleRepository;
    private final OrderSaleItemsRepository orderSaleItemsRepository;
    private final ClientService clientService;
    private final UserService userService;
    private final ProductService productService;
    private final SalesBudgetService salesBudgetService;

    @Autowired
    public OrderSaleService(OrderSaleRepository orderSale, ClientService client, UserService user, OrderSaleItemsRepository orderItems, ProductService product, SalesBudgetService salesBudget) {
        this.orderSaleRepository = orderSale;
        this.clientService = client;
        this.userService = user;
        this.orderSaleItemsRepository = orderItems;
        this.productService = product;
        this.salesBudgetService = salesBudget;
    }

    public OrderSale save(OrderSaleDto saleDto) {

        Client client = clientService.find(saleDto.getClient());
        User user = userService.find(saleDto.getUser());
        List<OrderSaleItemsDto> items = saleDto.getOrderSaleItems();

        //código destinado a localizar o preço unitario em caso do valor da OrderSaleItemsDto(items) estar zerado
        //a intenção aqui foi dar a opção ao cliente de usar o valor personalizado, ou do próprio cad. do produto

        items.stream().filter(e -> e.getUnitaryValue() == null).forEach(e -> {
            e.setUnitaryValue(
                    productService.find( e.getProduct() ).getSaleValue()
            );
        });
        // nessa parte fazemos o calculo do valor unitário contido no OrderSaleItemsDto(items) multiplicando pela quantidade.

        items.stream().forEach(e -> e.setTotalValue(e.getUnitaryValue().multiply(e.getAmount())));

        // foi mapeado o valor total de cada OrderSaleItem(item) e somado para  valor total pertencente ao OrderSale

        BigDecimal total = items.stream().map(a -> a.getTotalValue()).reduce((a, e) -> a.add(e)).get();


        List<OrderSaleItems> orderSaleItems =
                items.stream().map(e -> {
                    //nessa parte peguei o cód do produto que esta no OrderSaleItemsdto, e fiz a busca através do código
                    Product product = productService.find(e.getProduct());
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

    public OrderSale ImportBudget(long id) {
        SalesBudget sale = salesBudgetService.findById(id);
        List<OrderSaleItems> orderSaleItems = sale.getBudgetItems().stream().map(e ->
                OrderSaleItems.builder()
                        .amount(e.getAmount())
                        .unitaryValue(e.getUnitaryValue())
                        .product(e.getProduct())
                        .totalValue(e.getTotalValue())
                        .build()).collect(Collectors.toList());
        orderSaleItems.forEach(e -> orderSaleItemsRepository.save(e));


        OrderSale orderSale = OrderSale.builder()
                .orderSaleItems(orderSaleItems)
                .client(sale.getClient())
                .user(sale.getUser())
                .totalValue(sale.getTotalValue())
                .build();
        return orderSaleRepository.save(orderSale);
    }

    public OrderSale find(long id) {
        Optional<OrderSale> data = orderSaleRepository.findById(id);
        return data.orElse(null);
    }

    public void delete(long id) {
        orderSaleRepository.deleteById(id);
    }

    public List<OrderSale> findAll() {
        return orderSaleRepository.findAll();
    }

}
