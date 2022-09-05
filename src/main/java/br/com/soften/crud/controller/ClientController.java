package br.com.soften.crud.controller;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	ClientService clientService;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Client data){
		Client cad = clientService.save(data);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/save").buildAndExpand(data.getId()).toUri();
		return ResponseEntity.created(uri).body(data);
	}

	@GetMapping("findbyid/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Client obj = clientService.findById(id);
		return ResponseEntity.ok(obj);
		}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		clientService.delete(id);
		return ResponseEntity.ok("Client id" + id + "erased");
	}

	@GetMapping("findbyname/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name){
		List<Client> obj = clientService.findByName(name);
		return ResponseEntity.ok(obj);
	}
}
