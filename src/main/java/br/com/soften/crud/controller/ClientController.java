package br.com.soften.crud.controller;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	ClientService clientService;

	@GetMapping("findbyid/{id}")
	public ResponseEntity<?> save(@PathVariable long id){
		Optional<?> client =clientService.findById(id);
		return client.isPresent()? ResponseEntity.ok(client) : ResponseEntity.badRequest().build();
	}


	@PostMapping("save")
	public ResponseEntity<?> save(@RequestBody Client client){
		Client req = clientService.save(client);
		return ResponseEntity.ok(req);
	}

	@PostMapping("put")
	public ResponseEntity<?> update(@RequestBody Client client){
		Client req = clientService.save(client);
		return ResponseEntity.ok(req);
	}



	@GetMapping("/findall")
	public ResponseEntity<?> findall(){
		return ResponseEntity.ok(clientService.findAll());
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable long id) { return ResponseEntity.ok(clientService.delete(id)); }
}
