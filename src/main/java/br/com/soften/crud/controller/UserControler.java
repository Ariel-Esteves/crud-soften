package br.com.soften.crud.controller;


import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@Controller
@RestController
@RequestMapping("/user")
public class UserControler {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User data){
        User cad = userService.save(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/save").buildAndExpand(data.getId()).toUri();
        return ResponseEntity.created(uri).body(data);
    }

    @GetMapping("findbyid/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok("User id" + id + "erased");
    }

}
