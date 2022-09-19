package br.com.soften.crud.services;

import br.com.soften.crud.exceptions.ResourceNotFoundException;
import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepository = userRepo;
    }

    public User save(User data) {
        return userRepository.save(data);
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }


    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    ;

}
