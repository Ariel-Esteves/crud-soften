package br.com.soften.crud.repositories;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public List<Client> findByNameContaining(String name);
}
