package br.com.soften.crud.services;
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

    public User save (User req){ return userRepository.save(req) ; }

    public Optional<User> findById(long id){return userRepository.findById(id); }

    public List<User> findAll(){return userRepository.findAll();}

    public String delete(long id){
        Optional<User> user = findById(id);
        boolean res = user.isPresent() ? true  : false;

        if(res){
            userRepository.delete(user.get());
            return "done";
        } else {
            return "not found";
        }
    }


}
