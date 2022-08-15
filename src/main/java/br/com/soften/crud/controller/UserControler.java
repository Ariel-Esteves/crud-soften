package br.com.soften.crud.controller;

import br.com.soften.crud.models.entities.User;
import br.com.soften.crud.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/user")
public class UserControler {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User entity){
        User res = userService.save(entity);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<User> res = userService.findAll();
        return ResponseEntity.ok(res);
    }

    @PostMapping("/post")
    public ResponseEntity<?> replace(@RequestBody User user){
        User req = userService.save(user);
        return ResponseEntity.ok(req);
    }


}
