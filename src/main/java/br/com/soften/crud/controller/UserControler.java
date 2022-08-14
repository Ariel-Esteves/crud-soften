package br.com.soften.crud.controller;

import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/User")
public class UserControler {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User entity){
        User res = userService.save(entity);
        return ResponseEntity.ok(res);
    }

    public ResponseEntity<?> findAll(){
        List<User> res = userService.findAll();
        return ResponseEntity.ok(res);
    }


}
