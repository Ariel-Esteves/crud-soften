package br.com.soften.crud.controller;


import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@Controller
@RestController
@RequestMapping("/user")
public class UserControler {
    private final UserService userService;

    @Autowired
    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User data) {
        User cad = userService.save(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/save").buildAndExpand(data.getId()).toUri();
        return ResponseEntity.created(uri).body(data);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        if(id == null){
            User obj = userService.find(id);
            return ResponseEntity.ok(obj);
        }else{
            List<User> all = userService.find();
            return ResponseEntity.ok(all);
        }
    }

        @DeleteMapping("delete/{id}")
        public ResponseEntity<?> delete(@PathVariable long id){
            userService.delete(id);
            return ResponseEntity.ok("user " + id + "deleted");
        }
        
}
