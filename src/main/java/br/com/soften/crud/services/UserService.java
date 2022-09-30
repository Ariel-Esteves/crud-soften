package br.com.soften.crud.services;

import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public User find(Long id) {
        User obj = userRepository.findById(id).orElse(null);
        return obj;
    }

    public List<User> find() {
        List<User> obj = userRepository.findAll();
        return obj;
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}
