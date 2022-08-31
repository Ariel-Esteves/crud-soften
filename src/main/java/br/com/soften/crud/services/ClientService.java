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

	//implementar verificação da existencia do cliente
	public Client save (Client req){return clientRepository.save(req) ; }

	public Client findById(long id){
		Optional<Client> find = clientRepository.findById(id);
		Client result = find.isPresent() ? find.get() : clientRepository.findById(id).get();
		return result; }

	public List<Client> findAll(){return clientRepository.findAll();}

	public String delete(long id){
		Client client = findById(id);
		if(client.getName() != "consumidor"){
			clientRepository.delete(client);
			return "done";
		} else {
			return "not found";
		}
	}

}
