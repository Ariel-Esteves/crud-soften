package br.com.soften.crud.services;

import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;


@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public Client save(Client data){ return clientRepository.save(data); }

	public Client findById( Long id ){
		Optional<Client> obj = clientRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		}

	public List<Client> findByName( String data ){
		List<Client> obj = clientRepository.findByNameContaining(data);
		return obj;
				}

	public void delete(Long id) {
		Client data =this.findById(id);
		clientRepository.delete(data);
	}

	public List<Client> findAll(){return clientRepository.findAll();}
}
