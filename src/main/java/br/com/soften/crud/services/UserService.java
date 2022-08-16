package br.com.soften.crud.services;

import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){ return userRepository.findAll();}

    public User save(User user){return userRepository.save(user);}

    public User replace(User user){return userRepository.save(user);}


}
