package br.com.soften.crud.services;

import br.com.soften.crud.models.Dto.OrderItemsDto;
import br.com.soften.crud.models.entities.OrderItems;
import br.com.soften.crud.repositories.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderItemsService {

	@Autowired
	private OrderItemsRepository orderItemsRepository;

	public OrderItems save (OrderItemsDto req){
		Optional<?> orderItems =ProductService.findById(req.getProduct_id());
		return orderItems.isPresent()? ResponseEntity.ok(orderItems) : ResponseEntity.badRequest().build();
		return orderItemsRepository.save(req) ; }

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
