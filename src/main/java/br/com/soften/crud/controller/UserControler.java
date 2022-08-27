package br.com.soften.crud.controller;


import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RestController
@RequestMapping("/user")
public class UserControler {

    @Autowired
    UserService userService;

    @GetMapping("findbyid/{id}")
    public ResponseEntity<?> save(@PathVariable long id){
        Optional<?> user =userService.findById(id);
        return user.isPresent()? ResponseEntity.ok(user) : ResponseEntity.badRequest().build();
    }


    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody User user){
        User req = userService.save(user);
        return ResponseEntity.ok(req);
    }

    @PostMapping("put")
    public ResponseEntity<?> update(@RequestBody User user){
        User req = userService.save(user);
        return ResponseEntity.ok(req);
    }



    @GetMapping("/findall")
    public ResponseEntity<?> findall(){
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable long id) { return ResponseEntity.ok(userService.delete(id)); }

}
