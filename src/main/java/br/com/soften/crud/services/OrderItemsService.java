package br.com.soften.crud.services;

import br.com.soften.crud.models.Dto.OrderItemsDto;
import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.OrderItems;
import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.repositories.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
public class OrderItemsService {

	@Autowired
	private OrderItemsRepository orderItemsRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private ClientService clientService;

	public OrderItems save (OrderItemsDto req) {
		Product product = productService.findById(req.getProduct_id());
		Client client = clientService.findById(req.getClient());
		BigDecimal saleValue = product.getSaleValue();
		return orderItemsRepository.save(
		OrderItems.builder()
				.client(client)
				.product_id(product)
				.amount(req.getAmount())
				.unitaryValue(saleValue)
				.totalValue(saleValue.multiply(req.getAmount())	)
				.build()
					);

	}

	public Optional<OrderItems> findById(long id){ return orderItemsRepository.findById(id);}

	public List<OrderItems> findAll(){return orderItemsRepository.findAll();}

	public String delete(long id){
		Optional<OrderItems> orderItems = findById(id);
		boolean res = orderItems.isPresent() ? true  : false;

		if(res){
			orderItemsRepository.delete(orderItems.get());
			return "done";
		} else {
			return "not found";
		}
	}

}
