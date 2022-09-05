package br.com.soften.crud.services;
import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User data){ return userRepository.save(data); }

    public User findById( Long id ){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }


    public User delete(Long id) {
        Optional<User> data = userRepository.findById(id);
        return data.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<User> findAll(){return userRepository.findAll();}
}
