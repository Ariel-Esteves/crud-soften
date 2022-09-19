package br.com.soften.crud.services;

import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService{
    private final ClientRepository clientRepository;
    @Autowired
    private ClientService(ClientRepository clientRepository){this.clientRepository = clientRepository;}


    public Client save( Client data ){
        return clientRepository.save(data);
    }

    public Client findById( Long id ){
        Optional<Client> obj = clientRepository.findById(id);
        return obj.orElseThrow(( ) -> new ResourceNotFoundException(id));
    }

    public List<Client> findByName( String data ){
        return clientRepository.findByNameContaining(data);
    }

    public void delete( Long id ){
        clientRepository.deleteById(id);
    }

    public List<Client> findAll( ){
        return clientRepository.findAll();
    }
}
