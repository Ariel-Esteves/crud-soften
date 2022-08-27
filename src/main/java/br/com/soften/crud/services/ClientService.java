package br.com.soften.crud.services;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public Client save (Client req){ return clientRepository.save(req) ; }

	public Optional<Client> findById(long id){return clientRepository.findById(id); }

	public List<Client> findAll(){return clientRepository.findAll();}

	public String delete(long id){
		Optional<Client> client = findById(id);
		boolean res = client.isPresent() ? true  : false;

		if(res){
			clientRepository.delete(client.get());
			return "done";
		} else {
			return "not found";
		}
	}

}
