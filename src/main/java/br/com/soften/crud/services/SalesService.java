package br.com.soften.crud.services;
import br.com.soften.crud.models.Dto.SalesDto;
import br.com.soften.crud.models.entities.OrderItems;
import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.models.entities.Sales;
import br.com.soften.crud.repositories.ProductRepository;
import br.com.soften.crud.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private OrderItemsService orderItemsService;

    public Sales save (SalesDto req){


        final BigDecimal[] totalValue = {new BigDecimal(0)};
        Set<OrderItems> order = new HashSet<>();

        req.getOrderedItems().stream()
                .forEach(item -> {
                    Optional<OrderItems> result = orderItemsService.findById(item);
                    order.add(result.get());

                   totalValue[0] = totalValue[0].add(new BigDecimal(result.get().getTotalValue().doubleValue()) );
                });

        return salesRepository.save( Sales.builder()
                .orderedItems(order)
                .totalValue(totalValue[0])
                .build()) ; }

    public Optional<Sales> findById(long id){return salesRepository.findById(id); }

    public List<Sales> findAll(){return salesRepository.findAll();}

    public String delete(long id){
        Optional<Sales> sales = findById(id);
        boolean res = sales.isPresent() ? true  : false;

        if(res){
            salesRepository.delete(sales.get());
            return "done";
        } else {
            return "not found";
        }
    }

}
