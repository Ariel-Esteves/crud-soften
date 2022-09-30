package br.com.soften.crud.services;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final UserService userService;

    @Autowired
    private ClientService(ClientRepository clientRepository, UserService userService) {
        this.clientRepository = clientRepository;
        this.userService = userService;
    }


    public Client save(Client data, long user_id) {
        User user = userService.find(user_id);
        data.setUser(user);
        return clientRepository.save(data);
    }

    public Client find(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> find(String name) {
        return clientRepository.findByNameContaining(name);
    }


    public List<Client> findByName(String data) {
        return clientRepository.findByNameContaining(data);
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
